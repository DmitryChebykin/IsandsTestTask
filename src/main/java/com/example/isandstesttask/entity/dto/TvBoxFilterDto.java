package com.example.isandstesttask.entity.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TvBoxFilterDto extends BaseProductFilterDto {
    private String category;
    private String technology;

    public TvBoxFilterDto() {
    }

    public TvBoxFilterDto(String id, String producingCountry, String brandName, boolean isOnlineOrdering, boolean isSoldByInstallments, boolean isAvailable, String modelName, String serialNumber, String colorName, String maxPrice, String minPrice, String size, String category, String technology) {
        super();
        this.category = category;
        this.technology = technology;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTechnology() {
        return this.technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }
}