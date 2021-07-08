package com.example.isandstesttask.test;

import com.example.isandstesttask.entity.dto.BaseProductResponseDto;

public interface RefrigeratorCreateDto extends BaseProductResponseDto {
    String getCategory();

    void setCategory(String category);

    String getTechnology();

    void setTechnology(String technology);
}