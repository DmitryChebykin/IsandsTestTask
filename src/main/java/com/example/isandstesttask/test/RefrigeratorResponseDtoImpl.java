package com.example.isandstesttask.test;

import com.example.isandstesttask.entity.dto.TvBoxResponseDto;
import com.example.isandstesttask.entity.dto.response.BaseProductResponseDtoImpl;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.math.BigDecimal;

@ToString(callSuper = true)
@Setter
@Getter
public class RefrigeratorResponseDtoImpl extends BaseProductResponseDtoImpl implements TvBoxResponseDto {
    private String category;
    private String technology;

    public RefrigeratorResponseDtoImpl(String id, String productType, String producingCountry, String brandName, boolean isOnlineOrdering, boolean isSoldByInstallments, boolean isAvailable, String modelName, String serialNumber, String colorName, BigDecimal price, String size, String category, String technology) {
        super(id, productType, producingCountry, brandName, isOnlineOrdering, isSoldByInstallments, isAvailable, modelName, serialNumber, colorName, price, size);
        this.category = category;
        this.technology = technology;
    }

    public RefrigeratorResponseDtoImpl() {
    }

    @Override
    public void setProductType() {

    }
}