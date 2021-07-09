package com.example.isandstesttask.entity.dto;

import com.example.isandstesttask.entity.dto.BaseProductResponseDto;

public interface PcBoxCreateDto extends BaseProductResponseDto {
    String getCategory();

    void setCategory(String category);

    String getProcessorType();

    void setProcessorType(String processorType);
}