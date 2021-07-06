package com.example.isandstesttask.entity.mapper;

import com.example.isandstesttask.entity.BaseEntity;
import com.example.isandstesttask.entity.dto.response.BaseProductResponseDtoImpl;

public interface GenericMapper<E extends BaseEntity, D extends BaseProductResponseDtoImpl> {
    E asEntity(D dto);

    D asDTO(E entity);

}