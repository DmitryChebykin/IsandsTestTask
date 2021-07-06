package com.example.isandstesttask.entity.dto.response;

public interface TvBoxResponseDto extends BaseProductResponseDto{
    void setCategory(String category);

    void setTechnology(String technology);

    String getCategory();

    String getTechnology();
}