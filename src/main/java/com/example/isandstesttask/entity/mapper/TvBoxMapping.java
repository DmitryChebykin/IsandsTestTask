package com.example.isandstesttask.entity.mapper;

import com.example.isandstesttask.entity.dto.response.TvBoxResponseDto;
import com.example.isandstesttask.entity.product.TvBox;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TvBoxMapping {
    TvBoxMapping INSTANCE = Mappers.getMapper(TvBoxMapping.class);

    TvBoxResponseDto toDto(TvBox tvDto);
}