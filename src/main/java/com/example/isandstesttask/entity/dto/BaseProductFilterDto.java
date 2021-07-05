package com.example.isandstesttask.entity.dto;

import com.example.isandstesttask.entity.product.TvBox;
import java.util.List;

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
    private List<TvBox> tvBoxes;

    public BaseProductFilterDto() {
    }

    public BaseProductFilterDto(String id, String producingCountry, String brandName, boolean isOnlineOrdering, boolean isSoldByInstallments, boolean isAvailable, String modelName, String serialNumber, String colorName, String maxPrice, String minPrice, String size, List<TvBox> tvBoxes) {
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
        this.tvBoxes = tvBoxes;
    }

    public static final class BaseProductFilterDtoBuilder {
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
        private List<TvBox> tvBoxes;

        private BaseProductFilterDtoBuilder() {
        }

        public static BaseProductFilterDtoBuilder aBaseProductFilterDto() {
            return new BaseProductFilterDtoBuilder();
        }

        public BaseProductFilterDtoBuilder id(String id) {
            this.id = id;
            return this;
        }

        public BaseProductFilterDtoBuilder producingCountry(String producingCountry) {
            this.producingCountry = producingCountry;
            return this;
        }

        public BaseProductFilterDtoBuilder brandName(String brandName) {
            this.brandName = brandName;
            return this;
        }

        public BaseProductFilterDtoBuilder isOnlineOrdering(boolean isOnlineOrdering) {
            this.isOnlineOrdering = isOnlineOrdering;
            return this;
        }

        public BaseProductFilterDtoBuilder isSoldByInstallments(boolean isSoldByInstallments) {
            this.isSoldByInstallments = isSoldByInstallments;
            return this;
        }

        public BaseProductFilterDtoBuilder isAvailable(boolean isAvailable) {
            this.isAvailable = isAvailable;
            return this;
        }

        public BaseProductFilterDtoBuilder modelName(String modelName) {
            this.modelName = modelName;
            return this;
        }

        public BaseProductFilterDtoBuilder serialNumber(String serialNumber) {
            this.serialNumber = serialNumber;
            return this;
        }

        public BaseProductFilterDtoBuilder colorName(String colorName) {
            this.colorName = colorName;
            return this;
        }

        public BaseProductFilterDtoBuilder maxPrice(String maxPrice) {
            this.maxPrice = maxPrice;
            return this;
        }

        public BaseProductFilterDtoBuilder minPrice(String minPrice) {
            this.minPrice = minPrice;
            return this;
        }

        public BaseProductFilterDtoBuilder size(String size) {
            this.size = size;
            return this;
        }

        public BaseProductFilterDtoBuilder tvBoxes(List<TvBox> tvBoxes) {
            this.tvBoxes = tvBoxes;
            return this;
        }

        public BaseProductFilterDto build() {
            return new BaseProductFilterDto(id, producingCountry, brandName, isOnlineOrdering, isSoldByInstallments, isAvailable, modelName, serialNumber, colorName, maxPrice, minPrice, size, tvBoxes);
        }
    }
}