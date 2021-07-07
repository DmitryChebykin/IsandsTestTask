package com.example.isandstesttask.config;

import com.example.isandstesttask.entity.product.TvBox;
import com.example.isandstesttask.entity.reference.Brand;
import com.example.isandstesttask.entity.reference.Color;
import com.example.isandstesttask.service.TvBoxService;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Component
public class DbCsvInit {
    @Resource
    private TvBoxService tvBoxService;
    @Resource
    private ApplicationArguments applicationArguments;

    public DbCsvInit(TvBoxService tvBoxService) {
        this.tvBoxService = tvBoxService;
    }

    @EventListener
    public void run(ApplicationReadyEvent event) {
        if (applicationArguments.containsOption("init")) {
               InitDB();
        }
    }

    public void InitDB() {
        String[] CSV_COLUMNS;

        ClassLoader loader = DbCsvInit.class.getClassLoader();
        File file = new File(Objects.requireNonNull(loader.getResource("static/tvBox.csv")).getFile());

        CSVReader csvReader;
        List<String[]> csvLines = null;

        try {
            csvReader = new CSVReader(new FileReader(file));
            csvLines = csvReader.readAll();
        } catch (IOException | CsvException e) {
            e.printStackTrace();
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
                TvBox tvBox = TvBox.TvBoxBuilder.aTvBox()
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

                tvBoxService.createTvBox(tvBox);
            }
        }
    }
}