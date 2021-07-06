package com.example.isandstesttask.entity.dto;

public interface TvBoxCreateDto extends BaseProductResponseDto{
    String getCategory();

    void setCategory(String category);

    String getTechnology();

    void setTechnology(String technology);
}