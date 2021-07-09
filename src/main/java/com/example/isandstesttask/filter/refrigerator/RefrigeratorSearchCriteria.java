package com.example.isandstesttask.filter.refrigerator;

import com.example.isandstesttask.entity.reference.Brand;
import com.example.isandstesttask.entity.reference.Color;
import com.example.isandstesttask.filter.BaseSearchCriteria;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor
public class RefrigeratorSearchCriteria extends BaseSearchCriteria {
    private Optional<String> compressorType;
    private Optional<Integer> doorsNumber;

    public static final class RefrigeratorSearchCriteriaBuilder {
        private Optional<UUID> id;
        private Optional<String> producingCountry;
        private Optional<Brand> brandName;
        private Optional<Boolean> isOnlineOrdering;
        private Optional<Boolean> isSoldByInstallments;
        private Optional<Boolean> isAvailable;
        private Optional<String> modelName;
        private Optional<String> serialNumber;
        private Optional<Color> colorName;
        private Optional<BigDecimal> maxPrice;
        private Optional<BigDecimal> minPrice;
        private Optional<String> size;
        private Optional<String> compressorType;
        private Optional<Integer> doorsNumber;

        private RefrigeratorSearchCriteriaBuilder() {
        }

        public static RefrigeratorSearchCriteriaBuilder aRefrigeratorSearchCriteria() {
            return new RefrigeratorSearchCriteriaBuilder();
        }

        public RefrigeratorSearchCriteriaBuilder id(Optional<UUID> id) {
            this.id = id;
            return this;
        }

        public RefrigeratorSearchCriteriaBuilder producingCountry(Optional<String> producingCountry) {
            this.producingCountry = producingCountry;
            return this;
        }

        public RefrigeratorSearchCriteriaBuilder brandName(Optional<Brand> brandName) {
            this.brandName = brandName;
            return this;
        }

        public RefrigeratorSearchCriteriaBuilder isOnlineOrdering(Optional<Boolean> isOnlineOrdering) {
            this.isOnlineOrdering = isOnlineOrdering;
            return this;
        }

        public RefrigeratorSearchCriteriaBuilder isSoldByInstallments(Optional<Boolean> isSoldByInstallments) {
            this.isSoldByInstallments = isSoldByInstallments;
            return this;
        }

        public RefrigeratorSearchCriteriaBuilder isAvailable(Optional<Boolean> isAvailable) {
            this.isAvailable = isAvailable;
            return this;
        }

        public RefrigeratorSearchCriteriaBuilder modelName(Optional<String> modelName) {
            this.modelName = modelName;
            return this;
        }

        public RefrigeratorSearchCriteriaBuilder serialNumber(Optional<String> serialNumber) {
            this.serialNumber = serialNumber;
            return this;
        }

        public RefrigeratorSearchCriteriaBuilder colorName(Optional<Color> colorName) {
            this.colorName = colorName;
            return this;
        }

        public RefrigeratorSearchCriteriaBuilder maxPrice(Optional<BigDecimal> maxPrice) {
            this.maxPrice = maxPrice;
            return this;
        }

        public RefrigeratorSearchCriteriaBuilder minPrice(Optional<BigDecimal> minPrice) {
            this.minPrice = minPrice;
            return this;
        }

        public RefrigeratorSearchCriteriaBuilder size(Optional<String> size) {
            this.size = size;
            return this;
        }

        public RefrigeratorSearchCriteriaBuilder compressorType(Optional<String> compressorType) {
            this.compressorType = compressorType;
            return this;
        }

        public RefrigeratorSearchCriteriaBuilder doorsNumber(Optional<Integer> doorsNumber) {
            this.doorsNumber = doorsNumber;
            return this;
        }

        public RefrigeratorSearchCriteria build() {
            RefrigeratorSearchCriteria refrigeratorSearchCriteria = new RefrigeratorSearchCriteria();
            refrigeratorSearchCriteria.setId(id);
            refrigeratorSearchCriteria.setProducingCountry(producingCountry);
            refrigeratorSearchCriteria.setBrandName(brandName);
            refrigeratorSearchCriteria.setIsOnlineOrdering(isOnlineOrdering);
            refrigeratorSearchCriteria.setIsSoldByInstallments(isSoldByInstallments);
            refrigeratorSearchCriteria.setIsAvailable(isAvailable);
            refrigeratorSearchCriteria.setModelName(modelName);
            refrigeratorSearchCriteria.setSerialNumber(serialNumber);
            refrigeratorSearchCriteria.setColorName(colorName);
            refrigeratorSearchCriteria.setMaxPrice(maxPrice);
            refrigeratorSearchCriteria.setMinPrice(minPrice);
            refrigeratorSearchCriteria.setSize(size);
            refrigeratorSearchCriteria.setCompressorType(compressorType);
            refrigeratorSearchCriteria.setDoorsNumber(doorsNumber);
            return refrigeratorSearchCriteria;
        }
    }
}