package com.example.isandstesttask.entity.dto.create;

import com.example.isandstesttask.entity.dto.TvBoxCreateDto;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Setter
@Getter
public class TvBoxCreatingDto extends BaseProductDto implements com.example.isandstesttask.entity.dto.TvBoxCreateDto {
    private String category;
    private String technology;

    public TvBoxCreatingDto(String productType, String producingCountry, String brandName, boolean isOnlineOrdering, boolean isSoldByInstallments, boolean isAvailable, String modelName, String serialNumber, String colorName, BigDecimal price, String size, String category, String technology) {
        super(productType, producingCountry, brandName, isOnlineOrdering, isSoldByInstallments, isAvailable, modelName, serialNumber, colorName, price, size);
        this.category = category;
        this.technology = technology;
    }

    public TvBoxCreatingDto() {
    }
}