package com.example.isandstesttask.filter.tvbox;

import com.example.isandstesttask.entity.reference.Brand;
import com.example.isandstesttask.entity.reference.Color;
import com.example.isandstesttask.filter.BaseSearchCriteria;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

@Setter
@Getter
public class VacuumCleanerSearchCriteria extends BaseSearchCriteria {
    private Optional<BigDecimal> DustContainerVolume;
    private Optional<Integer> ModesNumber;

    public static final class VacuumCleanerSearchCriteriaBuilder {
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
        private Optional<BigDecimal> DustContainerVolume;
        private Optional<Integer> ModesNumber;

        private VacuumCleanerSearchCriteriaBuilder() {
        }

        public static VacuumCleanerSearchCriteriaBuilder aVacuumCleanerSearchCriteria() {
            return new VacuumCleanerSearchCriteriaBuilder();
        }

        public VacuumCleanerSearchCriteriaBuilder id(Optional<UUID> id) {
            this.id = id;
            return this;
        }

        public VacuumCleanerSearchCriteriaBuilder producingCountry(Optional<String> producingCountry) {
            this.producingCountry = producingCountry;
            return this;
        }

        public VacuumCleanerSearchCriteriaBuilder brandName(Optional<Brand> brandName) {
            this.brandName = brandName;
            return this;
        }

        public VacuumCleanerSearchCriteriaBuilder isOnlineOrdering(Optional<Boolean> isOnlineOrdering) {
            this.isOnlineOrdering = isOnlineOrdering;
            return this;
        }

        public VacuumCleanerSearchCriteriaBuilder isSoldByInstallments(Optional<Boolean> isSoldByInstallments) {
            this.isSoldByInstallments = isSoldByInstallments;
            return this;
        }

        public VacuumCleanerSearchCriteriaBuilder isAvailable(Optional<Boolean> isAvailable) {
            this.isAvailable = isAvailable;
            return this;
        }

        public VacuumCleanerSearchCriteriaBuilder modelName(Optional<String> modelName) {
            this.modelName = modelName;
            return this;
        }

        public VacuumCleanerSearchCriteriaBuilder serialNumber(Optional<String> serialNumber) {
            this.serialNumber = serialNumber;
            return this;
        }

        public VacuumCleanerSearchCriteriaBuilder colorName(Optional<Color> colorName) {
            this.colorName = colorName;
            return this;
        }

        public VacuumCleanerSearchCriteriaBuilder maxPrice(Optional<BigDecimal> maxPrice) {
            this.maxPrice = maxPrice;
            return this;
        }

        public VacuumCleanerSearchCriteriaBuilder minPrice(Optional<BigDecimal> minPrice) {
            this.minPrice = minPrice;
            return this;
        }

        public VacuumCleanerSearchCriteriaBuilder size(Optional<String> size) {
            this.size = size;
            return this;
        }

        public VacuumCleanerSearchCriteriaBuilder DustContainerVolume(Optional<BigDecimal> DustContainerVolume) {
            this.DustContainerVolume = DustContainerVolume;
            return this;
        }

        public VacuumCleanerSearchCriteriaBuilder ModesNumber(Optional<Integer> ModesNumber) {
            this.ModesNumber = ModesNumber;
            return this;
        }

        public VacuumCleanerSearchCriteria build() {
            VacuumCleanerSearchCriteria vacuumCleanerSearchCriteria = new VacuumCleanerSearchCriteria();
            vacuumCleanerSearchCriteria.setId(id);
            vacuumCleanerSearchCriteria.setProducingCountry(producingCountry);
            vacuumCleanerSearchCriteria.setBrandName(brandName);
            vacuumCleanerSearchCriteria.setIsOnlineOrdering(isOnlineOrdering);
            vacuumCleanerSearchCriteria.setIsSoldByInstallments(isSoldByInstallments);
            vacuumCleanerSearchCriteria.setIsAvailable(isAvailable);
            vacuumCleanerSearchCriteria.setModelName(modelName);
            vacuumCleanerSearchCriteria.setSerialNumber(serialNumber);
            vacuumCleanerSearchCriteria.setColorName(colorName);
            vacuumCleanerSearchCriteria.setMaxPrice(maxPrice);
            vacuumCleanerSearchCriteria.setMinPrice(minPrice);
            vacuumCleanerSearchCriteria.setSize(size);
            vacuumCleanerSearchCriteria.DustContainerVolume = this.DustContainerVolume;
            vacuumCleanerSearchCriteria.ModesNumber = this.ModesNumber;
            return vacuumCleanerSearchCriteria;
        }
    }
}