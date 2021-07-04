package com.example.isandstesttask;

import com.example.isandstesttask.entity.product.TvBox;
import com.example.isandstesttask.entity.reference.Brand;
import com.example.isandstesttask.service.TvBoxService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.DataSource;
import java.math.BigDecimal;

@SpringBootApplication
public class IsandsTestTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(IsandsTestTaskApplication.class, args);
    }


}