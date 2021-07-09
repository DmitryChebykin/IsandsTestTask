package com.example.isandstesttask.entity.dto.response;

import com.example.isandstesttask.entity.dto.RefrigeratorResponseDto;
import com.example.isandstesttask.entity.dto.TvBoxResponseDto;
import com.example.isandstesttask.entity.dto.response.BaseProductResponseDtoImpl;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.math.BigDecimal;

@ToString(callSuper = true)
@Setter
@Getter
public class RefrigeratorResponseDtoImpl extends BaseProductResponseDtoImpl implements RefrigeratorResponseDto {
    private String compressorType;
    private Integer doorsNumber;

    public RefrigeratorResponseDtoImpl(String id, String productType, String producingCountry, String brandName, Boolean isOnlineOrdering, Boolean isSoldByInstallments, Boolean available, String modelName, String serialNumber, String colorName, BigDecimal price, String size, String compressorType, Integer doorsNumber) {
        super(id, productType, producingCountry, brandName, isOnlineOrdering, isSoldByInstallments, available, modelName, serialNumber, colorName, price, size);
        this.compressorType = compressorType;
        this.doorsNumber = doorsNumber;
    }

    public RefrigeratorResponseDtoImpl() {
    }

    @Override
    public void setProductType() {

    }
}