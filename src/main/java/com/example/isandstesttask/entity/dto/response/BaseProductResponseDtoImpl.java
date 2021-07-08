package com.example.isandstesttask.entity.dto.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.math.BigDecimal;
@ToString(callSuper = true)
@Setter
@Getter
public class BaseProductResponseDtoImpl {
    public BaseProductResponseDtoImpl() {
    }

    public BaseProductResponseDtoImpl(String id, String productType, String producingCountry, String brandName, Boolean isOnlineOrdering, Boolean isSoldByInstallments, Boolean available, String modelName, String serialNumber, String colorName, BigDecimal price, String size) {
        this.id = id;
        this.productType = productType;
        this.producingCountry = producingCountry;
        this.brandName = brandName;
        this.isOnlineOrdering = isOnlineOrdering;
        this.isSoldByInstallments = isSoldByInstallments;
        this.available = available;
        this.modelName = modelName;
        this.serialNumber = serialNumber;
        this.colorName = colorName;
        this.price = price;
        this.size = size;
    }

    private String id;
    private String productType;
    private String producingCountry;
    private String brandName;
    private Boolean isOnlineOrdering;
    private Boolean isSoldByInstallments;
    private Boolean available;
    private String modelName;
    private String serialNumber;
    private String colorName;
    private BigDecimal price;
    private String size;
}