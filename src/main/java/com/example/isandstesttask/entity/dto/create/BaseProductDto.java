package com.example.isandstesttask.entity.dto.create;

import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Setter
@Getter
public class BaseProductDto {
    private String producingCountry;
    private String brandName;
    private Boolean isOnlineOrdering;
    private Boolean isSoldByInstallments;
    private Boolean available;
    private String modelName;
    private String serialNumber;
    private String colorName;
    private BigDecimal price;
    private String size;

    public BaseProductDto() {
    }

    public BaseProductDto(String producingCountry, String brandName, boolean isOnlineOrdering, boolean isSoldByInstallments, boolean isAvailable, String modelName, String serialNumber, String colorName, BigDecimal price, String size) {
        this.producingCountry = producingCountry;
        this.brandName = brandName;
        this.isOnlineOrdering = isOnlineOrdering;
        this.isSoldByInstallments = isSoldByInstallments;
        this.available = isAvailable;
        this.modelName = modelName;
        this.serialNumber = serialNumber;
        this.colorName = colorName;
        this.price = price;
        this.size = size;
    }
}