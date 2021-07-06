package com.example.isandstesttask.entity.dto.create;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Setter
@Getter
public class TvBoxDto extends BaseProductDTO {
    @NotNull
    private String category;
    @NotNull
    private String technology;

    public TvBoxDto(String productType, String producingCountry, String brandName, boolean isOnlineOrdering, boolean isSoldByInstallments, boolean isAvailable, String modelName, String serialNumber, String colorName, BigDecimal price, String size, String category, String technology) {
        super(productType, producingCountry, brandName, isOnlineOrdering, isSoldByInstallments, isAvailable, modelName, serialNumber, colorName, price, size);
        this.category = category;
        this.technology = technology;
    }

    public TvBoxDto() {
    }
}