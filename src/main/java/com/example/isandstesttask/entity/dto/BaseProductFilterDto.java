package com.example.isandstesttask.entity.dto;

public class BaseProductFilterDto {
    private String id;
    private String producingCountry;
    private String brandName;
    private boolean isOnlineOrdering;
    private boolean isSoldByInstallments;
    private boolean isAvailable;
    private String modelName;
    private String serialNumber;
    private String colorName;
    private String maxPrice;
    private String minPrice;
    private String size;

    public BaseProductFilterDto() {
    }

    public BaseProductFilterDto(String id, String producingCountry, String brandName, boolean isOnlineOrdering, boolean isSoldByInstallments, boolean isAvailable, String modelName, String serialNumber, String colorName, String maxPrice, String minPrice, String size) {
        this.id = id;
        this.producingCountry = producingCountry;
        this.brandName = brandName;
        this.isOnlineOrdering = isOnlineOrdering;
        this.isSoldByInstallments = isSoldByInstallments;
        this.isAvailable = isAvailable;
        this.modelName = modelName;
        this.serialNumber = serialNumber;
        this.colorName = colorName;
        this.maxPrice = maxPrice;
        this.minPrice = minPrice;
        this.size = size;
    }

    public String getId() {
        return this.id;
    }

    public String getProducingCountry() {
        return this.producingCountry;
    }

    public String getBrandName() {
        return this.brandName;
    }

    public boolean isOnlineOrdering() {
        return this.isOnlineOrdering;
    }

    public boolean isSoldByInstallments() {
        return this.isSoldByInstallments;
    }

    public boolean isAvailable() {
        return this.isAvailable;
    }

    public String getModelName() {
        return this.modelName;
    }

    public String getSerialNumber() {
        return this.serialNumber;
    }

    public String getColorName() {
        return this.colorName;
    }

    public String getMaxPrice() {
        return this.maxPrice;
    }

    public String getMinPrice() {
        return this.minPrice;
    }

    public String getSize() {
        return this.size;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setProducingCountry(String producingCountry) {
        this.producingCountry = producingCountry;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public void setOnlineOrdering(boolean isOnlineOrdering) {
        this.isOnlineOrdering = isOnlineOrdering;
    }

    public void setSoldByInstallments(boolean isSoldByInstallments) {
        this.isSoldByInstallments = isSoldByInstallments;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public void setMaxPrice(String maxPrice) {
        this.maxPrice = maxPrice;
    }

    public void setMinPrice(String minPrice) {
        this.minPrice = minPrice;
    }

    public void setSize(String size) {
        this.size = size;
    }
}