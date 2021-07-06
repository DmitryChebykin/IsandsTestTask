package com.example.isandstesttask.entity.dto.response;

import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.UUID;

@Setter
@Getter
public class TvBoxResponseDto extends BaseProductResponseDto {
    private String category;
    private String technology;

    public TvBoxResponseDto(UUID id, String productType, String producingCountry, String brandName, boolean isOnlineOrdering, boolean isSoldByInstallments, boolean isAvailable, String modelName, String serialNumber, String colorName, BigDecimal price, String size, String category, String technology) {
        super(id, productType, producingCountry, brandName, isOnlineOrdering, isSoldByInstallments, isAvailable, modelName, serialNumber, colorName, price, size);
        this.category = category;
        this.technology = technology;
    }

    public TvBoxResponseDto() {
    }
}