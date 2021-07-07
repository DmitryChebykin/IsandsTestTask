package com.example.isandstesttask.entity.dto.response;

import com.example.isandstesttask.entity.dto.TvBoxResponseDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.math.BigDecimal;

@ToString(callSuper = true)
@Setter
@Getter
public class TvBoxResponseDtoImpl extends BaseProductResponseDtoImpl implements TvBoxResponseDto {
    private String category;
    private String technology;

    public TvBoxResponseDtoImpl(String id, String productType, String producingCountry, String brandName, boolean isOnlineOrdering, boolean isSoldByInstallments, boolean isAvailable, String modelName, String serialNumber, String colorName, BigDecimal price, String size, String category, String technology) {
        super(id, productType, producingCountry, brandName, isOnlineOrdering, isSoldByInstallments, isAvailable, modelName, serialNumber, colorName, price, size);
        this.category = category;
        this.technology = technology;
    }

    public TvBoxResponseDtoImpl() {
    }

    @Override
    public void setProductType() {

    }
}