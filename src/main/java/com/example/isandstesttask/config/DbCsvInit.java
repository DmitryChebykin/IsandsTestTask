package com.example.isandstesttask.config;

import com.example.isandstesttask.entity.product.TvBoxImpl;
import com.example.isandstesttask.entity.product.VacuumCleanerImpl;
import com.example.isandstesttask.entity.reference.Brand;
import com.example.isandstesttask.entity.reference.Color;
import com.example.isandstesttask.service.TvBoxService;
import com.example.isandstesttask.service.VacuumCleanerService;
import com.opencsv.CSVReader;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.io.File;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

@Component
public class DbCsvInit {
    @Resource
    private TvBoxService tvBoxService;
    @Resource
    private ApplicationArguments applicationArguments;
    @Resource
    private VacuumCleanerService vacuumCleanerService;

    @EventListener
    public void run(ApplicationReadyEvent event) {
        if (applicationArguments.containsOption("init")) {
            InitDB();
        }
    }

    public void InitDB() {
        String[] CSV_COLUMNS;

        ClassLoader loader = DbCsvInit.class.getClassLoader();
        File file = null;
        CSVReader csvReader;
        List<String[]> csvLines;

        try {
            file = new File((loader.getResource("static/tvBox.csv")).getFile());
            csvReader = new CSVReader(new FileReader(file));
            csvLines = csvReader.readAll();
        } catch (Exception e) {
            System.out.println("Csv file read problem, check it correct?");
            return;
        }

        if (csvLines != null) {
            for (int i = 1; i < csvLines.size(); i++) {
                CSV_COLUMNS = csvLines.get(i)[0].split(";");

                String CATEGORY = CSV_COLUMNS[0];
                String TECHNOLOGY = CSV_COLUMNS[1];
                Boolean AVAILABLE = Boolean.valueOf(CSV_COLUMNS[2]);
                String MODEL = CSV_COLUMNS[4];
                Boolean ONLINE_ORDER = Boolean.valueOf(CSV_COLUMNS[5]);
                Boolean SOLD_BY_INSTALMENTS = Boolean.valueOf(CSV_COLUMNS[6]);
                BigDecimal PRICE = new BigDecimal(CSV_COLUMNS[8]);
                String COUNTRY = CSV_COLUMNS[9];
                String SIZE = CSV_COLUMNS[10];
                String SERIAL = CSV_COLUMNS[11];

                Brand brand = Brand.BrandBuilder.aBrand().brandName(CSV_COLUMNS[3]).build();
                Color color = Color.ColorBuilder.aColor().withColorName(CSV_COLUMNS[7]).build();

                TvBoxImpl tvBox = getBox(CATEGORY, TECHNOLOGY, AVAILABLE, MODEL, ONLINE_ORDER, SOLD_BY_INSTALMENTS, PRICE, COUNTRY, SIZE, SERIAL, brand, color);

                VacuumCleanerImpl vacuumCleaner = new VacuumCleanerImpl();

                tvBoxService.addTvBox(tvBox);

                patchVacuumCleaner(tvBox, vacuumCleaner);
                vacuumCleanerService.addVacuumCleaner(vacuumCleaner);

                patchTvBoxV1(tvBox);
                tvBoxService.addTvBox(tvBox);

                patchVacuumCleaner(tvBox, vacuumCleaner);
                vacuumCleanerService.addVacuumCleaner(vacuumCleaner);

                patchTvBoxV2(tvBox);
                tvBoxService.addTvBox(tvBox);

                patchVacuumCleaner(tvBox, vacuumCleaner);
                vacuumCleanerService.addVacuumCleaner(vacuumCleaner);


                if (i % 100 == 0) {
                    System.out.println("Добавлено строк " + i + " из " + csvLines.size());
                }
            }
        }
        System.out.println("Загрузка завершена.");
    }

    private void patchVacuumCleaner(TvBoxImpl tvBox, VacuumCleanerImpl vacuumCleaner) {
        BeanUtils.copyProperties(tvBox, vacuumCleaner);
        vacuumCleaner.setModesNumber((int) (Math.random() * 10) + 1);
        vacuumCleaner.setDustContainerVolume(BigDecimal.valueOf(Math.random() * 4 + 3));
    }

    private void patchTvBoxV2(TvBoxImpl tvBox) {
        tvBox.setId(null);
        tvBox.setCategory("65");
        tvBox.setSerialNumber(getRandomString());
        tvBox.setIsOnlineOrdering(!tvBox.getIsOnlineOrdering());
        tvBox.setPrice(tvBox.getPrice().multiply(BigDecimal.valueOf(Math.random() + 0.1)));
    }

    private void patchTvBoxV1(TvBoxImpl tvBox) {
        tvBox.setCategory("50");
        tvBox.setId(null);
        tvBox.setSerialNumber(getRandomString());
        tvBox.setPrice(tvBox.getPrice().multiply(BigDecimal.valueOf(Math.random() + 0.1)));
    }

    private TvBoxImpl getBox(String CATEGORY, String TECHNOLOGY, Boolean AVAILABLE, String MODEL, Boolean ONLINE_ORDER, Boolean SOLD_BY_INSTALMENTS, BigDecimal PRICE, String COUNTRY, String SIZE, String SERIAL, Brand brand, Color color) {
        TvBoxImpl tvBox = TvBoxImpl.TvBoxBuilder.aTvBox()
                .category(CATEGORY)
                .technology(TECHNOLOGY)
                .available(AVAILABLE)
                .modelName(MODEL)
                .isOnlineOrdering(ONLINE_ORDER)
                .isSoldByInstallments(SOLD_BY_INSTALMENTS)
                .price(PRICE)
                .producingCountry(COUNTRY)
                .size(SIZE)
                .serialNumber(SERIAL)
                .brandName(brand)
                .colorName(color)
                .build();
        return tvBox;
    }

    private String getRandomString() {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}