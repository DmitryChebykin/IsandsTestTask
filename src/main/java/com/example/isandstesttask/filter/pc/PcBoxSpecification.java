package com.example.isandstesttask.filter.pc;

import com.example.isandstesttask.entity.reference.Brand;
import com.example.isandstesttask.entity.reference.Color;
import com.example.isandstesttask.filter.metamodel.PcBoxImpl_;
import com.example.isandstesttask.test.PcBoxImpl;
import com.example.isandstesttask.filter.pc.PcBoxSearchCriteria;
import org.springframework.data.jpa.domain.Specification;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.Optional;
import java.util.function.Function;

public final class PcBoxSpecification {
    private PcBoxSpecification() {
    }

    public static Specification<PcBoxImpl> createPcBoxSpecification(PcBoxSearchCriteria pcBoxSearchCriteria) {
        Specification<PcBoxImpl> colorSpec = colorIs(pcBoxSearchCriteria.getColorName());
        Specification<PcBoxImpl> brandSpec = brandIs(pcBoxSearchCriteria.getBrandName());
        Specification<PcBoxImpl> sizeSpec = sizeIs(pcBoxSearchCriteria.getSize());
        Specification<PcBoxImpl> modelNameSpec = modelIs(pcBoxSearchCriteria.getModelName());
        Specification<PcBoxImpl> countrySpec = countryIs(pcBoxSearchCriteria.getProducingCountry());
        Specification<PcBoxImpl> serialSpec = serialIs(pcBoxSearchCriteria.getSerialNumber());
        Specification<PcBoxImpl> minPriceSpec = hasPriceAbove(pcBoxSearchCriteria.getMinPrice());
        Specification<PcBoxImpl> maxPriceSpec = hasPriceUnder(pcBoxSearchCriteria.getMaxPrice());
        Specification<PcBoxImpl> availSpec = availableIs(pcBoxSearchCriteria.getIsAvailable());
        Specification<PcBoxImpl> onlineOrderingSpec = onlineOrderingIs(pcBoxSearchCriteria.getIsOnlineOrdering());
        Specification<PcBoxImpl> soldInstalmentsSpec = soldInstalmentsIs(pcBoxSearchCriteria.getIsSoldByInstallments());
        Specification<PcBoxImpl> categorySpec = categoryIs(pcBoxSearchCriteria.getCategory());
        Specification<PcBoxImpl> techSpec = processorTypeIs(pcBoxSearchCriteria.getProcessorType());

        return colorSpec
                .and(brandSpec)
                .and(availSpec)
                .and(onlineOrderingSpec)
                .and(soldInstalmentsSpec)
                .and(countrySpec)
                .and(modelNameSpec)
                .and(serialSpec)
                .and(sizeSpec)
                .and(minPriceSpec)
                .and(maxPriceSpec)
                .and(categorySpec)
                .and(techSpec);
    }

    private static Specification<PcBoxImpl> availableIs(Optional<Boolean> isAvailable) {
        return (root, query, builder) -> isAvailable.map(e -> builder.equal(root.get(PcBoxImpl_.AVAILABLE), e)).orElse(null);
    }

    private static Specification<PcBoxImpl> onlineOrderingIs(Optional<Boolean> isOnlineOrdering) {
        return (root, query, builder) -> isOnlineOrdering.map(e -> builder.equal(root.get(PcBoxImpl_.IS_ONLINE_ORDERING), e)).orElse(null);
    }

    private static Specification<PcBoxImpl> soldInstalmentsIs(Optional<Boolean> isSoldByInstallments) {
        return (root, query, builder) -> isSoldByInstallments.map(e -> builder.equal(root.get(PcBoxImpl_.IS_SOLD_BY_INSTALLMENTS), e)).orElse(null);
    }

    private static Specification<PcBoxImpl> sizeIs(Optional<String> size) {
        return (root, query, builder) -> size.map(newSize -> builder.equal(root.get(PcBoxImpl_.SIZE), newSize)).orElse(null);
    }

    public static Specification<PcBoxImpl> hasPriceAbove(Optional<BigDecimal> minPrice) {
        return (root, query, builder) -> minPrice.map(min ->
                builder.greaterThanOrEqualTo(root.get(PcBoxImpl_.PRICE), min)).orElse(null);
    }

    public static Specification<PcBoxImpl> hasPriceUnder(Optional<BigDecimal> maxPrice) {
        return (root, query, builder) -> maxPrice.map(min ->
                builder.lessThanOrEqualTo(root.get(PcBoxImpl_.PRICE), min)).orElse(null);
    }

    private static Specification<PcBoxImpl> modelIs(Optional<String> modelName) {
        return (root, query, builder) -> modelName.map(newModel -> builder.equal(
                builder.lower(root.get(PcBoxImpl_.MODEL_NAME)), newModel.toLowerCase())).orElse(null);
    }

    private static Specification<PcBoxImpl> serialIs(Optional<String> serial) {
        return (root, query, builder) -> serial.map(newSerial -> builder.equal(root.get(PcBoxImpl_.SERIAL_NUMBER), newSerial)).orElse(null);
    }

    private static Specification<PcBoxImpl> countryIs(Optional<String> producingCountry) {
        return (root, query, builder) -> producingCountry.map(new Function<String, Predicate>() {
            @Override
            public Predicate apply(String country) {
                return builder.equal(root.get(PcBoxImpl_.PRODUCING_COUNTRY), country);
            }
        }).orElse(null);
    }

    private static Specification<PcBoxImpl> brandIs(Optional<Brand> brandName) {
        return new Specification<PcBoxImpl>() {
            @Override
            public Predicate toPredicate(Root<PcBoxImpl> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
                return brandName.map(new Function<Brand, Predicate>() {
                    @Override
                    public Predicate apply(Brand newBrand) {
                        return builder.equal(root.get(PcBoxImpl_.BRAND_NAME), newBrand);
                    }
                }).orElse(null);
            }
        };
    }

    private static Specification<PcBoxImpl> colorIs(Optional<Color> colorName) {
        return new Specification<PcBoxImpl>() {
            @Override
            public Predicate toPredicate(Root<PcBoxImpl> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
                return colorName.map(new Function<Color, Predicate>() {
                    @Override
                    public Predicate apply(Color newColor) {
                        return builder.equal(root.get(PcBoxImpl_.COLOR_NAME), newColor);
                    }
                }).orElse(null);
            }
        };
    }

    private static Specification<PcBoxImpl> processorTypeIs(Optional<String> processorType) {
        return (root, query, builder) -> processorType.map(newTech -> builder.equal(root.get(PcBoxImpl_.PROCESSOR_TYPE), newTech)).orElse(null);
    }

    private static Specification<PcBoxImpl> categoryIs(Optional<String> category) {
        return (root, query, builder) -> category.map(newCategory -> builder.equal(root.get(PcBoxImpl_.CATEGORY), newCategory)).orElse(null);
    }
}