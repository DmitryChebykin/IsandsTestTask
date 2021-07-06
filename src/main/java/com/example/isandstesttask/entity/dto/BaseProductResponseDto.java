package com.example.isandstesttask.entity.dto;

public interface BaseProductResponseDto {
    String getProductType();

    String getProducingCountry();

    String getBrandName();

    Boolean getIsOnlineOrdering();

    Boolean getIsSoldByInstallments();

    Boolean getAvailable();

    String getModelName();

    void setModelName(String modelName);

    String getSerialNumber();

    void setSerialNumber(String serialNumber);

    String getColorName();

    void setColorName(String colorName);

    java.math.BigDecimal getPrice();

    void setPrice(java.math.BigDecimal price);

    String getSize();

    void setSize(String size);
}