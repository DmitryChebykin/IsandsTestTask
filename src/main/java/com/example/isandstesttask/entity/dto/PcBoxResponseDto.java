package com.example.isandstesttask.entity.dto;

import com.example.isandstesttask.entity.dto.BaseProductResponseDto;
import com.example.isandstesttask.entity.dto.IdDto;
import com.example.isandstesttask.entity.dto.PcBoxCreateDto;

public interface PcBoxResponseDto extends IdDto, BaseProductResponseDto, PcBoxCreateDto {
    void setProductType();

    String getProductType();
}