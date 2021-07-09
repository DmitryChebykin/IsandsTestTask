package com.example.isandstesttask.entity.dto.response;

import com.example.isandstesttask.entity.dto.PcBoxResponseDto;
import com.example.isandstesttask.entity.dto.response.BaseProductResponseDtoImpl;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.math.BigDecimal;

@ToString(callSuper = true)
@Setter
@Getter
public class PcBoxResponseDtoImpl extends BaseProductResponseDtoImpl implements PcBoxResponseDto {
    private String category;
    private String processorType;

    public PcBoxResponseDtoImpl(String id, String productType, String producingCountry, String brandName, boolean isOnlineOrdering, boolean isSoldByInstallments, boolean isAvailable, String modelName, String serialNumber, String colorName, BigDecimal price, String size, String category, String processorType) {
        super(id, productType, producingCountry, brandName, isOnlineOrdering, isSoldByInstallments, isAvailable, modelName, serialNumber, colorName, price, size);
        this.category = category;
        this.processorType = processorType;
    }

    public PcBoxResponseDtoImpl() {
    }

    @Override
    public void setProductType() {

    }
}