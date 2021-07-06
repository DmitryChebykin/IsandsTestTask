package com.example.isandstesttask.entity.product;

import com.example.isandstesttask.entity.BaseField;
import com.example.isandstesttask.entity.BaseProduct;
import com.example.isandstesttask.entity.DBField;
import com.example.isandstesttask.entity.reference.Brand;
import com.example.isandstesttask.entity.reference.Color;
import java.math.BigDecimal;
import java.sql.Timestamp;

public abstract class AbstractProduct extends BaseProduct implements DBField, BaseField {
    public AbstractProduct(Timestamp createdDate, Timestamp lastModifiedDate, String productType, String producingCountry, Brand brandName, Boolean isOnlineOrdering, Boolean isSoldByInstallments, Boolean available, String modelName, String serialNumber, Color colorName, BigDecimal price, String size) {
        super(createdDate, lastModifiedDate, productType, producingCountry, brandName, isOnlineOrdering, isSoldByInstallments, available, modelName, serialNumber, colorName, price, size);
    }

    public AbstractProduct() {
    }
}