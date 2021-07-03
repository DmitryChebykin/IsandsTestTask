package com.example.isandstesttask.entity.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BaseProductFilterDto {
    private String id;
    private String producingCountry;
    private String brandName;
    private boolean isOnlineOrdering;
    private boolean isSoldByInstallments;
    private boolean isAvailable;
    private String modelName;
    private String serialNumber;
    private String colorName;
    private String maxPrice;
    private String minPrice;
    private String size;

    public BaseProductFilterDto() {
    }

    public BaseProductFilterDto(String id, String producingCountry, String brandName, boolean isOnlineOrdering, boolean isSoldByInstallments, boolean isAvailable, String modelName, String serialNumber, String colorName, String maxPrice, String minPrice, String size) {
        this.id = id;
        this.producingCountry = producingCountry;
        this.brandName = brandName;
        this.isOnlineOrdering = isOnlineOrdering;
        this.isSoldByInstallments = isSoldByInstallments;
        this.isAvailable = isAvailable;
        this.modelName = modelName;
        this.serialNumber = serialNumber;
        this.colorName = colorName;
        this.maxPrice = maxPrice;
        this.minPrice = minPrice;
        this.size = size;
    }
}