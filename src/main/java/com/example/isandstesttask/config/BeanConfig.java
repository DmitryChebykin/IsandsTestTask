package com.example.isandstesttask.config;

import net.minidev.json.JSONObject;
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
    public JSONObject jsonObject() {
        return new JSONObject();
    }
}