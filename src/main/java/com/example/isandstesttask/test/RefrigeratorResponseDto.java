package com.example.isandstesttask.test;

import com.example.isandstesttask.entity.dto.BaseProductResponseDto;
import com.example.isandstesttask.entity.dto.IdDto;

public interface RefrigeratorResponseDto extends IdDto, BaseProductResponseDto, RefrigeratorCreateDto {
    void setProductType();

    String getProductType();
}