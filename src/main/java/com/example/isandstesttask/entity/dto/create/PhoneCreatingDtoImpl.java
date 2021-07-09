package com.example.isandstesttask.entity.dto.create;

import com.example.isandstesttask.entity.dto.RefrigeratorCreateDto;
import com.example.isandstesttask.entity.dto.create.BaseProductDto;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Setter
@Getter
public class PhoneCreatingDtoImpl extends BaseProductDto implements RefrigeratorCreateDto.PhoneCreateDto {
    private Integer memorySize;
    private Integer camerasNumber;

    public PhoneCreatingDtoImpl(String producingCountry, String brandName, boolean isOnlineOrdering, boolean isSoldByInstallments, boolean isAvailable, String modelName, String serialNumber, String colorName, BigDecimal price, String size, Integer memorySize, Integer camerasNumber) {
        super(producingCountry, brandName, isOnlineOrdering, isSoldByInstallments, isAvailable, modelName, serialNumber, colorName, price, size);
        this.memorySize = memorySize;
        this.camerasNumber = camerasNumber;
    }

    public PhoneCreatingDtoImpl() {
    }
}