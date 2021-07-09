package com.example.isandstesttask.filter.phone;

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
public class PhoneSearchCriteria extends BaseSearchCriteria {
    private Optional<Integer> memorySize;
    private Optional<Integer> camerasNumber;

    public static final class PhoneSearchCriteriaBuilder {
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
        private Optional<Integer> memorySize;
        private Optional<Integer> camerasNumber;

        private PhoneSearchCriteriaBuilder() {
        }

        public static PhoneSearchCriteriaBuilder aPhoneSearchCriteria() {
            return new PhoneSearchCriteriaBuilder();
        }

        public PhoneSearchCriteriaBuilder id(Optional<UUID> id) {
            this.id = id;
            return this;
        }

        public PhoneSearchCriteriaBuilder producingCountry(Optional<String> producingCountry) {
            this.producingCountry = producingCountry;
            return this;
        }

        public PhoneSearchCriteriaBuilder brandName(Optional<Brand> brandName) {
            this.brandName = brandName;
            return this;
        }

        public PhoneSearchCriteriaBuilder isOnlineOrdering(Optional<Boolean> isOnlineOrdering) {
            this.isOnlineOrdering = isOnlineOrdering;
            return this;
        }

        public PhoneSearchCriteriaBuilder isSoldByInstallments(Optional<Boolean> isSoldByInstallments) {
            this.isSoldByInstallments = isSoldByInstallments;
            return this;
        }

        public PhoneSearchCriteriaBuilder isAvailable(Optional<Boolean> isAvailable) {
            this.isAvailable = isAvailable;
            return this;
        }

        public PhoneSearchCriteriaBuilder modelName(Optional<String> modelName) {
            this.modelName = modelName;
            return this;
        }

        public PhoneSearchCriteriaBuilder serialNumber(Optional<String> serialNumber) {
            this.serialNumber = serialNumber;
            return this;
        }

        public PhoneSearchCriteriaBuilder colorName(Optional<Color> colorName) {
            this.colorName = colorName;
            return this;
        }

        public PhoneSearchCriteriaBuilder maxPrice(Optional<BigDecimal> maxPrice) {
            this.maxPrice = maxPrice;
            return this;
        }

        public PhoneSearchCriteriaBuilder minPrice(Optional<BigDecimal> minPrice) {
            this.minPrice = minPrice;
            return this;
        }

        public PhoneSearchCriteriaBuilder size(Optional<String> size) {
            this.size = size;
            return this;
        }

        public PhoneSearchCriteriaBuilder memorySize(Optional<Integer> memorySize) {
            this.memorySize = memorySize;
            return this;
        }

        public PhoneSearchCriteriaBuilder camerasNumber(Optional<Integer> camerasNumber) {
            this.camerasNumber = camerasNumber;
            return this;
        }

        public PhoneSearchCriteria build() {
            PhoneSearchCriteria phoneSearchCriteria = new PhoneSearchCriteria();
            phoneSearchCriteria.setId(id);
            phoneSearchCriteria.setProducingCountry(producingCountry);
            phoneSearchCriteria.setBrandName(brandName);
            phoneSearchCriteria.setIsOnlineOrdering(isOnlineOrdering);
            phoneSearchCriteria.setIsSoldByInstallments(isSoldByInstallments);
            phoneSearchCriteria.setIsAvailable(isAvailable);
            phoneSearchCriteria.setModelName(modelName);
            phoneSearchCriteria.setSerialNumber(serialNumber);
            phoneSearchCriteria.setColorName(colorName);
            phoneSearchCriteria.setMaxPrice(maxPrice);
            phoneSearchCriteria.setMinPrice(minPrice);
            phoneSearchCriteria.setSize(size);
            phoneSearchCriteria.setMemorySize(memorySize);
            phoneSearchCriteria.setCamerasNumber(camerasNumber);
            return phoneSearchCriteria;
        }
    }
}