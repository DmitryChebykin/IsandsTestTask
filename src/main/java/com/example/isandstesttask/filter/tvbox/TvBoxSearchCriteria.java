package com.example.isandstesttask.filter.tvbox;

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
public class TvBoxSearchCriteria extends BaseSearchCriteria {
    private Optional<String> category;
    private Optional<String> technology;

    public static final class TvBoxSearchCriteriaBuilder {
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
        private Optional<String> category;
        private Optional<String> technology;

        private TvBoxSearchCriteriaBuilder() {
        }

        public static TvBoxSearchCriteriaBuilder aTvBoxSearchCriteria() {
            return new TvBoxSearchCriteriaBuilder();
        }

        public TvBoxSearchCriteriaBuilder id(Optional<UUID> id) {
            this.id = id;
            return this;
        }

        public TvBoxSearchCriteriaBuilder producingCountry(Optional<String> producingCountry) {
            this.producingCountry = producingCountry;
            return this;
        }

        public TvBoxSearchCriteriaBuilder brandName(Optional<Brand> brandName) {
            this.brandName = brandName;
            return this;
        }

        public TvBoxSearchCriteriaBuilder isOnlineOrdering(Optional<Boolean> isOnlineOrdering) {
            this.isOnlineOrdering = isOnlineOrdering;
            return this;
        }

        public TvBoxSearchCriteriaBuilder isSoldByInstallments(Optional<Boolean> isSoldByInstallments) {
            this.isSoldByInstallments = isSoldByInstallments;
            return this;
        }

        public TvBoxSearchCriteriaBuilder isAvailable(Optional<Boolean> isAvailable) {
            this.isAvailable = isAvailable;
            return this;
        }

        public TvBoxSearchCriteriaBuilder modelName(Optional<String> modelName) {
            this.modelName = modelName;
            return this;
        }

        public TvBoxSearchCriteriaBuilder serialNumber(Optional<String> serialNumber) {
            this.serialNumber = serialNumber;
            return this;
        }

        public TvBoxSearchCriteriaBuilder colorName(Optional<Color> colorName) {
            this.colorName = colorName;
            return this;
        }

        public TvBoxSearchCriteriaBuilder maxPrice(Optional<BigDecimal> maxPrice) {
            this.maxPrice = maxPrice;
            return this;
        }

        public TvBoxSearchCriteriaBuilder minPrice(Optional<BigDecimal> minPrice) {
            this.minPrice = minPrice;
            return this;
        }

        public TvBoxSearchCriteriaBuilder size(Optional<String> size) {
            this.size = size;
            return this;
        }

        public TvBoxSearchCriteriaBuilder category(Optional<String> category) {
            this.category = category;
            return this;
        }

        public TvBoxSearchCriteriaBuilder technology(Optional<String> technology) {
            this.technology = technology;
            return this;
        }

        public TvBoxSearchCriteria build() {
            TvBoxSearchCriteria tvBoxSearchCriteria = new TvBoxSearchCriteria();
            tvBoxSearchCriteria.setId(id);
            tvBoxSearchCriteria.setProducingCountry(producingCountry);
            tvBoxSearchCriteria.setBrandName(brandName);
            tvBoxSearchCriteria.setIsOnlineOrdering(isOnlineOrdering);
            tvBoxSearchCriteria.setIsSoldByInstallments(isSoldByInstallments);
            tvBoxSearchCriteria.setIsAvailable(isAvailable);
            tvBoxSearchCriteria.setModelName(modelName);
            tvBoxSearchCriteria.setSerialNumber(serialNumber);
            tvBoxSearchCriteria.setColorName(colorName);
            tvBoxSearchCriteria.setMaxPrice(maxPrice);
            tvBoxSearchCriteria.setMinPrice(minPrice);
            tvBoxSearchCriteria.setSize(size);
            tvBoxSearchCriteria.setCategory(category);
            tvBoxSearchCriteria.setTechnology(technology);
            return tvBoxSearchCriteria;
        }
    }
}