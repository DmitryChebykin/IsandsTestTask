package com.example.isandstesttask.entity.dto.create;

import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Setter
@Getter
public class VacuumCleanerCreatingDtoImpl extends BaseProductDto {
    private BigDecimal DustContainerVolume;
    private Integer ModesNumber;

    public VacuumCleanerCreatingDtoImpl() {
    }

    public VacuumCleanerCreatingDtoImpl(String producingCountry, String brandName, boolean isOnlineOrdering, boolean isSoldByInstallments, boolean isAvailable, String modelName, String serialNumber, String colorName, BigDecimal price, String size, BigDecimal dustContainerVolume, Integer modesNumber) {
        super(producingCountry, brandName, isOnlineOrdering, isSoldByInstallments, isAvailable, modelName, serialNumber, colorName, price, size);
        DustContainerVolume = dustContainerVolume;
        ModesNumber = modesNumber;
    }
}