package com.example.isandstesttask.config;

import com.example.isandstesttask.controller.VacuumCleanerSearchService;
import com.example.isandstesttask.entity.dto.create.TvBoxCreatingDtoImpl;
import com.example.isandstesttask.entity.dto.response.TvBoxResponseDtoImpl;
import com.example.isandstesttask.filter.TvBox.TvBoxSearchCriteria;
import com.example.isandstesttask.filter.TvBox.VacuumCleanerSearchCriteria;
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
    public TvBoxCreatingDtoImpl tvBoxDto() {
        return new TvBoxCreatingDtoImpl();
    }

    @Bean
    public TvBoxResponseDtoImpl tvBoxResponseDtoImpl() {
        return new TvBoxResponseDtoImpl();
    }

    @Bean
    public TvBoxSearchCriteria tvBoxSearchCriteria() {
        return new TvBoxSearchCriteria();
    }

    @Bean
    public VacuumCleanerSearchCriteria vacuumCleanerSearchCriteria() {
        return new VacuumCleanerSearchCriteria();
    }


}