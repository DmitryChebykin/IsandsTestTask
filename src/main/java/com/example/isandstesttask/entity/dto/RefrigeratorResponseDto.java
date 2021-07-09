package com.example.isandstesttask.entity.dto;

public interface RefrigeratorResponseDto extends IdDto, BaseProductResponseDto, RefrigeratorCreateDto {
    void setProductType();

    String getProductType();
}