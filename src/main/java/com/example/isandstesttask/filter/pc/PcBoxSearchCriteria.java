package com.example.isandstesttask.filter.pc;

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
public class PcBoxSearchCriteria extends BaseSearchCriteria {
    private Optional<String> category;
    private Optional<String> processorType;

    public static final class PcBoxSearchCriteriaBuilder {
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
        private Optional<String> processorType;

        private PcBoxSearchCriteriaBuilder() {
        }

        public static PcBoxSearchCriteriaBuilder aPcBoxSearchCriteria() {
            return new PcBoxSearchCriteriaBuilder();
        }

        public PcBoxSearchCriteriaBuilder id(Optional<UUID> id) {
            this.id = id;
            return this;
        }

        public PcBoxSearchCriteriaBuilder producingCountry(Optional<String> producingCountry) {
            this.producingCountry = producingCountry;
            return this;
        }

        public PcBoxSearchCriteriaBuilder brandName(Optional<Brand> brandName) {
            this.brandName = brandName;
            return this;
        }

        public PcBoxSearchCriteriaBuilder isOnlineOrdering(Optional<Boolean> isOnlineOrdering) {
            this.isOnlineOrdering = isOnlineOrdering;
            return this;
        }

        public PcBoxSearchCriteriaBuilder isSoldByInstallments(Optional<Boolean> isSoldByInstallments) {
            this.isSoldByInstallments = isSoldByInstallments;
            return this;
        }

        public PcBoxSearchCriteriaBuilder isAvailable(Optional<Boolean> isAvailable) {
            this.isAvailable = isAvailable;
            return this;
        }

        public PcBoxSearchCriteriaBuilder modelName(Optional<String> modelName) {
            this.modelName = modelName;
            return this;
        }

        public PcBoxSearchCriteriaBuilder serialNumber(Optional<String> serialNumber) {
            this.serialNumber = serialNumber;
            return this;
        }

        public PcBoxSearchCriteriaBuilder colorName(Optional<Color> colorName) {
            this.colorName = colorName;
            return this;
        }

        public PcBoxSearchCriteriaBuilder maxPrice(Optional<BigDecimal> maxPrice) {
            this.maxPrice = maxPrice;
            return this;
        }

        public PcBoxSearchCriteriaBuilder minPrice(Optional<BigDecimal> minPrice) {
            this.minPrice = minPrice;
            return this;
        }

        public PcBoxSearchCriteriaBuilder size(Optional<String> size) {
            this.size = size;
            return this;
        }

        public PcBoxSearchCriteriaBuilder category(Optional<String> category) {
            this.category = category;
            return this;
        }

        public PcBoxSearchCriteriaBuilder processorType(Optional<String> processorType) {
            this.processorType = processorType;
            return this;
        }

        public PcBoxSearchCriteria build() {
            PcBoxSearchCriteria pcBoxSearchCriteria = new PcBoxSearchCriteria();
            pcBoxSearchCriteria.setId(id);
            pcBoxSearchCriteria.setProducingCountry(producingCountry);
            pcBoxSearchCriteria.setBrandName(brandName);
            pcBoxSearchCriteria.setIsOnlineOrdering(isOnlineOrdering);
            pcBoxSearchCriteria.setIsSoldByInstallments(isSoldByInstallments);
            pcBoxSearchCriteria.setIsAvailable(isAvailable);
            pcBoxSearchCriteria.setModelName(modelName);
            pcBoxSearchCriteria.setSerialNumber(serialNumber);
            pcBoxSearchCriteria.setColorName(colorName);
            pcBoxSearchCriteria.setMaxPrice(maxPrice);
            pcBoxSearchCriteria.setMinPrice(minPrice);
            pcBoxSearchCriteria.setSize(size);
            pcBoxSearchCriteria.setCategory(category);
            pcBoxSearchCriteria.setProcessorType(processorType);
            return pcBoxSearchCriteria;
        }
    }
}