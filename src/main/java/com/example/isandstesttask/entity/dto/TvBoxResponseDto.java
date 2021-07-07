package com.example.isandstesttask.entity.dto;

public interface TvBoxResponseDto extends IdDto, BaseProductResponseDto, TvBoxCreateDto {
    void setProductType();

    String getProductType();
}