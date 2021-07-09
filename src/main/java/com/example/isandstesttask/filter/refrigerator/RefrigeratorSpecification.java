package com.example.isandstesttask.filter.refrigerator;

import com.example.isandstesttask.entity.product.RefrigeratorImpl;
import com.example.isandstesttask.entity.reference.Brand;
import com.example.isandstesttask.entity.reference.Color;
import com.example.isandstesttask.filter.metamodel.BaseProductImpl_;
import com.example.isandstesttask.filter.metamodel.RefrigeratorImpl_;
import org.springframework.data.jpa.domain.Specification;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.Optional;
import java.util.function.Function;

public final class RefrigeratorSpecification {
    private RefrigeratorSpecification() {
    }

    public static Specification<RefrigeratorImpl> createRefrigeratorSpecification(RefrigeratorSearchCriteria refrigeratorSearchCriteria) {
        Specification<RefrigeratorImpl> colorSpec = colorIs(refrigeratorSearchCriteria.getColorName());
        Specification<RefrigeratorImpl> brandSpec = brandIs(refrigeratorSearchCriteria.getBrandName());
        Specification<RefrigeratorImpl> sizeSpec = sizeIs(refrigeratorSearchCriteria.getSize());
        Specification<RefrigeratorImpl> modelNameSpec = modelIs(refrigeratorSearchCriteria.getModelName());
        Specification<RefrigeratorImpl> countrySpec = countryIs(refrigeratorSearchCriteria.getProducingCountry());
        Specification<RefrigeratorImpl> serialSpec = serialIs(refrigeratorSearchCriteria.getSerialNumber());
        Specification<RefrigeratorImpl> minPriceSpec = hasPriceAbove(refrigeratorSearchCriteria.getMinPrice());
        Specification<RefrigeratorImpl> maxPriceSpec = hasPriceUnder(refrigeratorSearchCriteria.getMaxPrice());
        Specification<RefrigeratorImpl> availSpec = availableIs(refrigeratorSearchCriteria.getIsAvailable());
        Specification<RefrigeratorImpl> onlineOrderingSpec = onlineOrderingIs(refrigeratorSearchCriteria.getIsOnlineOrdering());
        Specification<RefrigeratorImpl> soldInstalmentsSpec = soldInstalmentsIs(refrigeratorSearchCriteria.getIsSoldByInstallments());
        Specification<RefrigeratorImpl> compressorTypeSpec = compressorTypeIs(refrigeratorSearchCriteria.getCompressorType());
        Specification<RefrigeratorImpl> doorsNumberSpec = doorsNumberIs(refrigeratorSearchCriteria.getDoorsNumber());

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
                .and(compressorTypeSpec)
                .and(doorsNumberSpec);
    }

    private static Specification<RefrigeratorImpl> availableIs(Optional<Boolean> isAvailable) {
        return (root, query, builder) -> isAvailable.map(e -> builder.equal(root.get(BaseProductImpl_.AVAILABLE), e)).orElse(null);
    }

    private static Specification<RefrigeratorImpl> onlineOrderingIs(Optional<Boolean> isOnlineOrdering) {
        return (root, query, builder) -> isOnlineOrdering.map(e -> builder.equal(root.get(BaseProductImpl_.IS_ONLINE_ORDERING), e)).orElse(null);
    }

    private static Specification<RefrigeratorImpl> soldInstalmentsIs(Optional<Boolean> isSoldByInstallments) {
        return (root, query, builder) -> isSoldByInstallments.map(e -> builder.equal(root.get(BaseProductImpl_.IS_SOLD_BY_INSTALLMENTS), e)).orElse(null);
    }

    private static Specification<RefrigeratorImpl> sizeIs(Optional<String> size) {
        return (root, query, builder) -> size.map(newSize -> builder.equal(root.get(BaseProductImpl_.SIZE), newSize)).orElse(null);
    }

    public static Specification<RefrigeratorImpl> hasPriceAbove(Optional<BigDecimal> minPrice) {
        return (root, query, builder) -> minPrice.map(min ->
                builder.greaterThanOrEqualTo(root.get(BaseProductImpl_.PRICE), min)).orElse(null);
    }

    public static Specification<RefrigeratorImpl> hasPriceUnder(Optional<BigDecimal> maxPrice) {
        return (root, query, builder) -> maxPrice.map(min ->
                builder.lessThanOrEqualTo(root.get(BaseProductImpl_.PRICE), min)).orElse(null);
    }

    private static Specification<RefrigeratorImpl> modelIs(Optional<String> modelName) {
        return (root, query, builder) -> modelName.map(newModel -> builder.equal(
                builder.lower(root.get(BaseProductImpl_.MODEL_NAME)), newModel.toLowerCase())).orElse(null);
    }

    private static Specification<RefrigeratorImpl> serialIs(Optional<String> serial) {
        return (root, query, builder) -> serial.map(newSerial -> builder.equal(root.get(BaseProductImpl_.SERIAL_NUMBER), newSerial)).orElse(null);
    }

    private static Specification<RefrigeratorImpl> countryIs(Optional<String> producingCountry) {
        return (root, query, builder) -> producingCountry.map(new Function<String, Predicate>() {
            @Override
            public Predicate apply(String country) {
                return builder.equal(root.get(BaseProductImpl_.PRODUCING_COUNTRY), country);
            }
        }).orElse(null);
    }

    private static Specification<RefrigeratorImpl> brandIs(Optional<Brand> brandName) {
        return new Specification<RefrigeratorImpl>() {
            @Override
            public Predicate toPredicate(Root<RefrigeratorImpl> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
                return brandName.map(new Function<Brand, Predicate>() {
                    @Override
                    public Predicate apply(Brand newBrand) {
                        return builder.equal(root.get(BaseProductImpl_.BRAND_NAME), newBrand);
                    }
                }).orElse(null);
            }
        };
    }

    private static Specification<RefrigeratorImpl> colorIs(Optional<Color> colorName) {
        return new Specification<RefrigeratorImpl>() {
            @Override
            public Predicate toPredicate(Root<RefrigeratorImpl> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
                return colorName.map(new Function<Color, Predicate>() {
                    @Override
                    public Predicate apply(Color newColor) {
                        return builder.equal(root.get(BaseProductImpl_.COLOR_NAME), newColor);
                    }
                }).orElse(null);
            }
        };
    }

    private static Specification<RefrigeratorImpl> doorsNumberIs(Optional<Integer> doorsNumber) {
        return (root, query, builder) -> doorsNumber.map(newTech -> builder.equal(root.get(RefrigeratorImpl_.DOORS_NUMBER), newTech)).orElse(null);
    }

    private static Specification<RefrigeratorImpl> compressorTypeIs(Optional<String> compressorType) {
        return (root, query, builder) -> compressorType.map(newCategory -> builder.equal(root.get(RefrigeratorImpl_.COMPRESSOR_TYPE), newCategory)).orElse(null);
    }
}