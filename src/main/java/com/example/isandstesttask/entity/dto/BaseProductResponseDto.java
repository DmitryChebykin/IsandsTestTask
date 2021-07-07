package com.example.isandstesttask.entity.dto;

import java.math.BigDecimal;

public interface BaseProductResponseDto {
    String getProducingCountry();

    String getBrandName();

    void setBrandName(String brandName);

    Boolean getIsOnlineOrdering();

    Boolean getIsSoldByInstallments();

    Boolean getAvailable();

    String getModelName();

    void setModelName(String modelName);

    String getSerialNumber();

    void setSerialNumber(String serialNumber);

    String getColorName();

    void setColorName(String colorName);

    BigDecimal getPrice();

    void setPrice(BigDecimal price);

    String getSize();

    void setSize(String size);
}