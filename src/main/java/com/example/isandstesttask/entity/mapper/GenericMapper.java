package com.example.isandstesttask.entity.mapper;

import com.example.isandstesttask.entity.BaseEntity;
import com.example.isandstesttask.entity.dto.create.BaseProductDTO;

public interface GenericMapper<E extends BaseEntity, D extends BaseProductDTO> {
    E asEntity(D dto);

    D asDTO(E entity);

}