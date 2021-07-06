package com.example.isandstesttask.config;

import com.example.isandstesttask.entity.dto.TvBoxDto;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public TvBoxDto tvBoxDto() {
        return new TvBoxDto();
    }
}