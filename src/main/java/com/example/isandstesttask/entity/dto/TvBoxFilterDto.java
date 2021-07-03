package com.example.isandstesttask.entity.dto;

import com.example.isandstesttask.entity.reference.Brand;
import com.example.isandstesttask.entity.reference.Color;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.UUID;

@Setter
@Getter
public class TvBoxFilterDto extends BaseProductFilterDto {
    private String category;
    private String technology;

    public TvBoxFilterDto() {
    }

    public TvBoxFilterDto(String id, String producingCountry, String brandName, boolean isOnlineOrdering, boolean isSoldByInstallments, boolean isAvailable, String modelName, String serialNumber, String colorName, String maxPrice, String minPrice, String size, String category, String technology) {
        super(id, producingCountry, brandName, isOnlineOrdering, isSoldByInstallments, isAvailable, modelName, serialNumber, colorName, maxPrice, minPrice, size);
        this.category = category;
        this.technology = technology;
    }
}