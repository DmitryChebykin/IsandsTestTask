package com.example.isandstesttask.entity.dto.create;

import com.example.isandstesttask.entity.dto.PcBoxCreateDto;
import com.example.isandstesttask.entity.dto.create.BaseProductDto;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Setter
@Getter
public class PcBoxCreatingDtoImpl extends BaseProductDto implements PcBoxCreateDto {
    private String category;
    private String processorType;

    public PcBoxCreatingDtoImpl(String productType, String producingCountry, String brandName, boolean isOnlineOrdering, boolean isSoldByInstallments, boolean isAvailable, String modelName, String serialNumber, String colorName, BigDecimal price, String size, String category, String processorType) {
        super(producingCountry, brandName, isOnlineOrdering, isSoldByInstallments, isAvailable, modelName, serialNumber, colorName, price, size);
        this.category = category;
        this.processorType = processorType;
    }

    public PcBoxCreatingDtoImpl() {
    }
}