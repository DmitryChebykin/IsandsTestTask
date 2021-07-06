package com.example.isandstesttask.entity.dto.response;

public interface BaseProductResponseDto {
    void setModelName(String modelName);

    void setSerialNumber(String serialNumber);

    void setColorName(String colorName);

    void setPrice(java.math.BigDecimal price);

    void setSize(String size);

    java.util.UUID getId();

    String getProductType();

    String getProducingCountry();

    String getBrandName();

    Boolean getIsOnlineOrdering();

    Boolean getIsSoldByInstallments();

    Boolean getAvailable();

    String getModelName();

    String getSerialNumber();

    String getColorName();

    java.math.BigDecimal getPrice();

    String getSize();
}