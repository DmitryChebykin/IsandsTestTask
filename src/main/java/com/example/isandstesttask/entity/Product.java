package com.example.isandstesttask.entity;

import com.example.isandstesttask.entity.BaseEntity;
import com.example.isandstesttask.entity.BaseProduct;
import com.example.isandstesttask.entity.product.TvBox;

public interface Product extends BaseEntity, BaseProduct, TvBox {
    Long id = null;
}