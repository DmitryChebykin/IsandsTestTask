package com.example.isandstesttask.config;

import com.example.isandstesttask.entity.dto.create.TvBoxCreatingDto;
import com.example.isandstesttask.filter.TvBox.TvBoxSearchCriteria;
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
    public TvBoxCreatingDto tvBoxDto() {
        return new TvBoxCreatingDto();
    }

    @Bean
    public TvBoxSearchCriteria tvBoxSearchCriteria() {
        return new TvBoxSearchCriteria();
    }
}