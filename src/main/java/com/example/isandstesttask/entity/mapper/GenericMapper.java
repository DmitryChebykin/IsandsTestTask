package com.example.isandstesttask.entity.mapper;

import com.example.isandstesttask.entity.BaseEntity;
import com.example.isandstesttask.entity.dto.create.BaseProductDto;

public interface GenericMapper<E extends BaseEntity, D extends BaseProductDto> {
    E asEntity(D dto);

    D asDTO(E entity);

}