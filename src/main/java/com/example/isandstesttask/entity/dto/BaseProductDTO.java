package com.example.isandstesttask.entity.dto;

import com.example.isandstesttask.entity.reference.Brand;
import com.example.isandstesttask.entity.reference.Color;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.UUID;

@Setter
@Getter
public class BaseProductDTO {
    public BaseProductDTO() {
    }

    private UUID id;
    private String productType;
    private String producingCountry;
    private Brand brandName;

    public BaseProductDTO(UUID id, String productType, String producingCountry, Brand brandName, boolean isOnlineOrdering, boolean isSoldByInstallments, boolean isAvailable, String modelName, String serialNumber, Color colorName, BigDecimal price, String size) {
        this.id = id;
        this.productType = productType;
        this.producingCountry = producingCountry;
        this.brandName = brandName;
        this.isOnlineOrdering = isOnlineOrdering;
        this.isSoldByInstallments = isSoldByInstallments;
        this.isAvailable = isAvailable;
        this.modelName = modelName;
        this.serialNumber = serialNumber;
        this.colorName = colorName;
        this.price = price;
        this.size = size;
    }

    private boolean isOnlineOrdering;
    private boolean isSoldByInstallments;
    private boolean isAvailable;
    private String modelName;
    private String serialNumber;
    private Color colorName;

    private BigDecimal price;
    private String size;
}