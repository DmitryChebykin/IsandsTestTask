package com.example.isandstesttask.entity;

public interface BaseField extends DBField{

    void setProductType(String productType);

    void setProducingCountry(String producingCountry);

    void setBrandName(com.example.isandstesttask.entity.reference.Brand brandName);

    void setIsOnlineOrdering(Boolean isOnlineOrdering);

    void setIsSoldByInstallments(Boolean isSoldByInstallments);

    void setAvailable(Boolean available);

    void setModelName(String modelName);

    void setSerialNumber(String serialNumber);

    void setColorName(com.example.isandstesttask.entity.reference.Color colorName);

    void setPrice(java.math.BigDecimal price);

    void setSize(String size);

    String getProductType();

    String getProducingCountry();

    com.example.isandstesttask.entity.reference.Brand getBrandName();

    Boolean getIsOnlineOrdering();

    Boolean getIsSoldByInstallments();

    Boolean getAvailable();

    String getModelName();

    String getSerialNumber();

    com.example.isandstesttask.entity.reference.Color getColorName();

    java.math.BigDecimal getPrice();

    String getSize();
}