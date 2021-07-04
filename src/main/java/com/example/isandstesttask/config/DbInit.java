package com.example.isandstesttask.config;

import com.example.isandstesttask.entity.product.TvBox;
import com.example.isandstesttask.entity.reference.Brand;
import com.example.isandstesttask.entity.reference.Color;
import com.example.isandstesttask.service.TvBoxService;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@Component
public class DbInit {
    private TvBoxService tvBoxService;

    @Autowired
    public DbInit(TvBoxService tvBoxService) {
        this.tvBoxService = tvBoxService;
    }

    @EventListener
    public void postConstruct(ApplicationReadyEvent event) {
        ClassLoader loader = DbInit.class.getClassLoader();
        File file = new File(loader.getResource("static/tvBox.csv").getFile());

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
                String[] tv = csvLines.get(i)[0].split(";");
                Brand brand = Brand.BrandBuilder.aBrand().brandName(tv[3]).build();
                Color color = Color.ColorBuilder.aColor().withColorName(tv[7]).build();
                TvBox tvBox = TvBox.TvBoxBuilder
                        .aTvBox().category(tv[0]).technology(tv[1]).available(Boolean.valueOf(tv[2])).brandName(brand)
                        .modelName(tv[4]).isOnlineOrdering(Boolean.valueOf(tv[5])).isSoldByInstallments(Boolean.valueOf(tv[6])).colorName(color)
                        .price(BigDecimal.valueOf(Long.parseLong(tv[8]))).producingCountry(tv[9]).size(tv[10]).serialNumber(tv[11]).build();

                tvBoxService.createTvBox(tvBox);
            }
        }
    }
}