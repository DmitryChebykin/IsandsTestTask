package com.example.isandstesttask.filter.vacuumcleaner;

import com.example.isandstesttask.entity.product.VacuumCleanerImpl;
import com.example.isandstesttask.entity.reference.Brand;
import com.example.isandstesttask.entity.reference.Color;
import com.example.isandstesttask.filter.metamodel.BaseProductImpl_;
import com.example.isandstesttask.filter.metamodel.VacuumCleanerImpl_;
import org.springframework.data.jpa.domain.Specification;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.Optional;
import java.util.function.Function;

public class VacuumCleanerSpecification {
    public static Specification<VacuumCleanerImpl> createVacuumCleanerSpecifications(VacuumCleanerSearchCriteria vacuumCleanerSearchCriteria) {

        Specification<VacuumCleanerImpl> colorSpec = colorIs(vacuumCleanerSearchCriteria.getColorName());
        Specification<VacuumCleanerImpl> brandSpec = brandIs(vacuumCleanerSearchCriteria.getBrandName());
        Specification<VacuumCleanerImpl> sizeSpec = sizeIs(vacuumCleanerSearchCriteria.getSize());
        Specification<VacuumCleanerImpl> modelNameSpec = modelIs(vacuumCleanerSearchCriteria.getModelName());
        Specification<VacuumCleanerImpl> countrySpec = countryIs(vacuumCleanerSearchCriteria.getProducingCountry());
        Specification<VacuumCleanerImpl> serialSpec = serialIs(vacuumCleanerSearchCriteria.getSerialNumber());
        Specification<VacuumCleanerImpl> minPriceSpec = hasPriceAbove(vacuumCleanerSearchCriteria.getMinPrice());
        Specification<VacuumCleanerImpl> maxPriceSpec = hasPriceUnder(vacuumCleanerSearchCriteria.getMaxPrice());
        Specification<VacuumCleanerImpl> availSpec = availableIs(vacuumCleanerSearchCriteria.getIsAvailable());
        Specification<VacuumCleanerImpl> onlineOrderingSpec = onlineOrderingIs(vacuumCleanerSearchCriteria.getIsOnlineOrdering());
        Specification<VacuumCleanerImpl> soldInstalmentsSpec = soldInstalmentsIs(vacuumCleanerSearchCriteria.getIsSoldByInstallments());
        Specification<VacuumCleanerImpl> modesNumberSpec = modesNumberIs(vacuumCleanerSearchCriteria.getModesNumber());
        Specification<VacuumCleanerImpl> dustContainerSpec = dustContainerVolumeIs(vacuumCleanerSearchCriteria.getDustContainerVolume());

        return colorSpec.and(brandSpec)
                .and(availSpec)
                .and(onlineOrderingSpec)
                .and(soldInstalmentsSpec)
                .and(countrySpec)
                .and(modelNameSpec)
                .and(serialSpec)
                .and(sizeSpec)
                .and(minPriceSpec)
                .and(maxPriceSpec)
                .and(modesNumberSpec)
                .and(dustContainerSpec);
    }

    private static Specification<VacuumCleanerImpl> availableIs(Optional<Boolean> isAvailable) {
        return (root, query, builder) -> isAvailable.map(e -> builder.equal(root.get(BaseProductImpl_.AVAILABLE), e)).orElse(null);
    }

    private static Specification<VacuumCleanerImpl> onlineOrderingIs(Optional<Boolean> isOnlineOrdering) {
        return (root, query, builder) -> isOnlineOrdering.map(e -> builder.equal(root.get(BaseProductImpl_.IS_ONLINE_ORDERING), e)).orElse(null);
    }

    private static Specification<VacuumCleanerImpl> soldInstalmentsIs(Optional<Boolean> isSoldByInstallments) {
        return (root, query, builder) -> isSoldByInstallments.map(e -> builder.equal(root.get(BaseProductImpl_.IS_SOLD_BY_INSTALLMENTS), e)).orElse(null);
    }

    private static Specification<VacuumCleanerImpl> sizeIs(Optional<String> size) {
        return (root, query, builder) -> size.map(newSize -> builder.equal(root.get(BaseProductImpl_.SIZE), newSize)).orElse(null);
    }

    public static Specification<VacuumCleanerImpl> hasPriceAbove(Optional<BigDecimal> minPrice) {
        return (root, query, builder) -> minPrice.map(min ->
                builder.greaterThanOrEqualTo(root.get(BaseProductImpl_.PRICE), min)).orElse(null);
    }

    public static Specification<VacuumCleanerImpl> hasPriceUnder(Optional<BigDecimal> maxPrice) {
        return (root, query, builder) -> maxPrice.map(min ->
                builder.lessThanOrEqualTo(root.get(BaseProductImpl_.PRICE), min)).orElse(null);
    }

    private static Specification<VacuumCleanerImpl> modelIs(Optional<String> modelName) {
        return (root, query, builder) -> modelName.map(newModel -> builder.equal(
                builder.lower(root.get(BaseProductImpl_.MODEL_NAME)), newModel.toLowerCase())).orElse(null);
    }

    private static Specification<VacuumCleanerImpl> serialIs(Optional<String> serial) {
        return (root, query, builder) -> serial.map(newSerial -> builder.equal(root.get(BaseProductImpl_.SERIAL_NUMBER), newSerial)).orElse(null);
    }

    private static Specification<VacuumCleanerImpl> countryIs(Optional<String> producingCountry) {
        return (root, query, builder) -> producingCountry.map(new Function<String, Predicate>() {
            @Override
            public Predicate apply(String country) {
                return builder.equal(root.get(BaseProductImpl_.PRODUCING_COUNTRY), country);
            }
        }).orElse(null);
    }

    private static Specification<VacuumCleanerImpl> brandIs(Optional<Brand> brandName) {
        return new Specification<VacuumCleanerImpl>() {
            @Override
            public Predicate toPredicate(Root<VacuumCleanerImpl> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
                return brandName.map(new Function<Brand, Predicate>() {
                    @Override
                    public Predicate apply(Brand newBrand) {
                        return builder.equal(root.get(BaseProductImpl_.BRAND_NAME), newBrand);
                    }
                }).orElse(null);
            }
        };
    }

    private static Specification<VacuumCleanerImpl> colorIs(Optional<Color> colorName) {
        return new Specification<VacuumCleanerImpl>() {
            @Override
            public Predicate toPredicate(Root<VacuumCleanerImpl> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
                return colorName.map(new Function<Color, Predicate>() {
                    @Override
                    public Predicate apply(Color newColor) {
                        return builder.equal(root.get(BaseProductImpl_.COLOR_NAME), newColor);
                    }
                }).orElse(null);
            }
        };
    }

    private static Specification<VacuumCleanerImpl> modesNumberIs(Optional<Integer> modesNumber) {
        return (root, query, builder) -> modesNumber.map(newTech -> builder.equal(root.get(VacuumCleanerImpl_.MODES_NUMBER), newTech)).orElse(null);
    }

    private static Specification<VacuumCleanerImpl> dustContainerVolumeIs(Optional<BigDecimal> volume) {
        return (root, query, builder) -> volume.map(newTech -> builder.equal(root.get(VacuumCleanerImpl_.DUST_CONTAINER_VOLUME), newTech)).orElse(null);
    }
}