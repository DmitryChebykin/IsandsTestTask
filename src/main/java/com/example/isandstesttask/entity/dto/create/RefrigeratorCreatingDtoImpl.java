package com.example.isandstesttask.entity.dto.create;

import com.example.isandstesttask.entity.dto.RefrigeratorCreateDto;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Setter
@Getter
public class RefrigeratorCreatingDtoImpl extends BaseProductDto implements RefrigeratorCreateDto {
    private String category;
    private String technology;

    public RefrigeratorCreatingDtoImpl(String productType, String producingCountry, String brandName, boolean isOnlineOrdering, boolean isSoldByInstallments, boolean isAvailable, String modelName, String serialNumber, String colorName, BigDecimal price, String size, String category, String technology) {
        super(producingCountry, brandName, isOnlineOrdering, isSoldByInstallments, isAvailable, modelName, serialNumber, colorName, price, size);
        this.category = category;
        this.technology = technology;
    }

    public RefrigeratorCreatingDtoImpl() {
    }
}