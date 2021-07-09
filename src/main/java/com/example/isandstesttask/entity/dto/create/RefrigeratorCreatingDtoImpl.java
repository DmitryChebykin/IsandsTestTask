package com.example.isandstesttask.entity.dto.create;

import com.example.isandstesttask.entity.dto.RefrigeratorCreateDto;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Setter
@Getter
public class RefrigeratorCreatingDtoImpl extends BaseProductDto implements RefrigeratorCreateDto {
    private String compressorType;
    private Integer doorsNumber;

    public RefrigeratorCreatingDtoImpl(String producingCountry, String brandName, boolean isOnlineOrdering, boolean isSoldByInstallments, boolean isAvailable, String modelName, String serialNumber, String colorName, BigDecimal price, String size, String compressorType, Integer doorsNumber) {
        super(producingCountry, brandName, isOnlineOrdering, isSoldByInstallments, isAvailable, modelName, serialNumber, colorName, price, size);
        this.compressorType = compressorType;
        this.doorsNumber = doorsNumber;
    }

    public RefrigeratorCreatingDtoImpl() {
    }
}