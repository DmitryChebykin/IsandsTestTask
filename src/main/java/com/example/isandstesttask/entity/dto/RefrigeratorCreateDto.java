package com.example.isandstesttask.entity.dto;

public interface RefrigeratorCreateDto extends BaseProductResponseDto {
    String getCompressorType();

    void setCompressorType(String compressorType);

    Integer getDoorsNumber();

    void setDoorsNumber(Integer doorsNumber);
}