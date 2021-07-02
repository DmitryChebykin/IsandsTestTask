package com.example.isandstesttask.entity.dto;

import com.example.isandstesttask.entity.reference.Brand;
import com.example.isandstesttask.entity.reference.Color;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.UUID;

@Setter
@Getter
public class TelevisionProductDto extends BaseProductDTO {
    private String category;
    private String technology;

    public TelevisionProductDto(UUID id, String productType, String producingCountry, Brand brandName, boolean isOnlineOrdering, boolean isSoldByInstallments, boolean isAvailable, String modelName, String serialNumber, Color colorName, BigDecimal price, String size, String category, String technology) {
        super(id, productType, producingCountry, brandName, isOnlineOrdering, isSoldByInstallments, isAvailable, modelName, serialNumber, colorName, price, size);
        this.category = category;
        this.technology = technology;
    }


}