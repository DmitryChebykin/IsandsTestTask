package com.example.isandstesttask.config;

import com.example.isandstesttask.entity.dto.create.TvBoxCreatingDtoImpl;
import com.example.isandstesttask.entity.dto.create.VacuumCleanerCreatingDtoImpl;
import com.example.isandstesttask.entity.dto.response.TvBoxResponseDtoImpl;
import com.example.isandstesttask.filter.phone.PhoneSearchCriteria;
import com.example.isandstesttask.filter.refrigerator.RefrigeratorSearchCriteria;
import com.example.isandstesttask.filter.tvbox.TvBoxSearchCriteria;
import com.example.isandstesttask.filter.vacuumcleaner.VacuumCleanerSearchCriteria;
import com.example.isandstesttask.filter.pc.PcBoxSearchCriteria;
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
    public VacuumCleanerCreatingDtoImpl vacuumCleanerCreatingDto() {
        return new VacuumCleanerCreatingDtoImpl();
    }

    @Bean
    public TvBoxSearchCriteria tvBoxSearchCriteria() {
        return new TvBoxSearchCriteria();
    }

    @Bean
    public VacuumCleanerSearchCriteria vacuumCleanerSearchCriteria() {
        return new VacuumCleanerSearchCriteria();
    }

    @Bean
    public RefrigeratorSearchCriteria refrigeratorSearchCriteria() {
        return new RefrigeratorSearchCriteria();
    }

    @Bean
    public PhoneSearchCriteria phoneSearchCriteria() {
        return new PhoneSearchCriteria();
    }

    @Bean
    public PcBoxSearchCriteria pcBoxSearchCriteria() {
        return new PcBoxSearchCriteria();
    }
}