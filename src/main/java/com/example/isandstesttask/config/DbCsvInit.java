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
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.io.*;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Random;
import static java.nio.charset.StandardCharsets.UTF_8;

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
        String[] CsvColumnHeaders;

        ClassLoader loader = DbCsvInit.class.getClassLoader();
        File file = null;
        CSVReader csvReader;
        List<String[]> csvLines;


        ClassPathResource resource = new ClassPathResource("static/tvBox.csv");

        try {
            InputStream inputStream = resource.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,  StandardCharsets.UTF_8));
            csvReader = new CSVReader(bufferedReader);
            csvLines = csvReader.readAll();
        } catch (Exception e) {
            System.out.println("Csv file read problem, check it correct?");
            return;
        }

        if (csvLines != null) {
            for (int i = 1; i < csvLines.size(); i++) {
                CsvColumnHeaders = csvLines.get(i)[0].split(";");

                String CATEGORY = CsvColumnHeaders[0];
                String TECHNOLOGY = CsvColumnHeaders[1];
                Boolean AVAILABLE = Boolean.valueOf(CsvColumnHeaders[2]);
                String MODEL = CsvColumnHeaders[4];
                Boolean ONLINE_ORDER = Boolean.valueOf(CsvColumnHeaders[5]);
                Boolean SOLD_BY_INSTALMENTS = Boolean.valueOf(CsvColumnHeaders[6]);
                BigDecimal PRICE = new BigDecimal(CsvColumnHeaders[8]);
                String COUNTRY = CsvColumnHeaders[9];
                String SIZE = CsvColumnHeaders[10];
                String SERIAL = CsvColumnHeaders[11];

                Brand brand = Brand.BrandBuilder.aBrand().brandName(CsvColumnHeaders[3]).build();
                Color color = Color.ColorBuilder.aColor().withColorName(CsvColumnHeaders[7]).build();

                TvBoxImpl tvBox = getBox(CATEGORY, TECHNOLOGY, AVAILABLE, MODEL, ONLINE_ORDER, SOLD_BY_INSTALMENTS, PRICE, COUNTRY, SIZE, SERIAL, brand, color);

                VacuumCleanerImpl vacuumCleaner = new VacuumCleanerImpl();

                tvBoxService.createTvBox(tvBox);

                patchVacuumCleaner(tvBox, vacuumCleaner);
                vacuumCleanerService.addVacuumCleaner(vacuumCleaner);

                patchTvBoxV1(tvBox);
                tvBoxService.createTvBox(tvBox);

                patchVacuumCleaner(tvBox, vacuumCleaner);
                vacuumCleanerService.addVacuumCleaner(vacuumCleaner);

                patchTvBoxV2(tvBox);
                tvBoxService.createTvBox(tvBox);

                patchVacuumCleaner(tvBox, vacuumCleaner);
                vacuumCleanerService.addVacuumCleaner(vacuumCleaner);


                if (i % 100 == 0) {
                    System.out.println("Обработано строк " + i + " из " + csvLines.size());
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
        return TvBoxImpl.TvBoxBuilder.aTvBox()
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