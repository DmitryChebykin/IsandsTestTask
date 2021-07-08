package com.example.isandstesttask.filter.TvBox;

import com.example.isandstesttask.entity.TvBoxProduct;
import com.example.isandstesttask.entity.reference.Brand;
import com.example.isandstesttask.entity.reference.Color;
import com.example.isandstesttask.filter.BaseSearchCriteria;
import com.example.isandstesttask.filter.TvBox.metamodel.BaseProduct_;
import org.springframework.data.jpa.domain.Specification;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.Optional;
import java.util.function.Function;

public final class BaseSpecification {
    private BaseSpecification() {
    }

    public static Specification<TvBoxProduct> createTvBoxSpecifications(BaseSearchCriteria baseSearchCriteria) {
        Specification<TvBoxProduct> colorSpec = colorIs(baseSearchCriteria.getColorName());
        Specification<TvBoxProduct> brandSpec = brandIs(baseSearchCriteria.getBrandName());
        Specification<TvBoxProduct> sizeSpec = sizeIs(baseSearchCriteria.getSize());
        Specification<TvBoxProduct> modelNameSpec = modelIs(baseSearchCriteria.getModelName());
        Specification<TvBoxProduct> countrySpec = countryIs(baseSearchCriteria.getProducingCountry());
        Specification<TvBoxProduct> serialSpec = serialIs(baseSearchCriteria.getSerialNumber());
        Specification<TvBoxProduct> minPriceSpec = hasPriceAbove(baseSearchCriteria.getMinPrice());
        Specification<TvBoxProduct> maxPriceSpec = hasPriceUnder(baseSearchCriteria.getMaxPrice());
        Specification<TvBoxProduct> availSpec = availableIs(baseSearchCriteria.getIsAvailable());
        Specification<TvBoxProduct> onlineOrderingSpec = onlineOrderingIs(baseSearchCriteria.getIsOnlineOrdering());
        Specification<TvBoxProduct> soldInstalmentsSpec = soldInstalmentsIs(baseSearchCriteria.getIsSoldByInstallments());

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
                .and(maxPriceSpec);
    }

    private static Specification<TvBoxProduct> availableIs(Optional<Boolean> isAvailable) {
        return (root, query, builder) -> isAvailable.map(e -> builder.equal(root.get(BaseProduct_.AVAILABLE), e)).orElse(null);
    }

    private static Specification<TvBoxProduct> onlineOrderingIs(Optional<Boolean> isOnlineOrdering) {
        return (root, query, builder) -> isOnlineOrdering.map(e -> builder.equal(root.get(BaseProduct_.IS_ONLINE_ORDERING), e)).orElse(null);
    }

    private static Specification<TvBoxProduct> soldInstalmentsIs(Optional<Boolean> isSoldByInstallments) {
        return (root, query, builder) -> isSoldByInstallments.map(e -> builder.equal(root.get(BaseProduct_.IS_SOLD_BY_INSTALLMENTS), e)).orElse(null);
    }

    private static Specification<TvBoxProduct> sizeIs(Optional<String> size) {
        return (root, query, builder) -> size.map(newSize -> builder.equal(root.get(BaseProduct_.SIZE), newSize)).orElse(null);
    }

    public static Specification<TvBoxProduct> hasPriceAbove(Optional<BigDecimal> minPrice) {
        return (root, query, builder) -> minPrice.map(min ->
                builder.greaterThanOrEqualTo(root.get(BaseProduct_.PRICE), min)).orElse(null);
    }

    public static Specification<TvBoxProduct> hasPriceUnder(Optional<BigDecimal> maxPrice) {
        return (root, query, builder) -> maxPrice.map(min ->
                builder.lessThanOrEqualTo(root.get(BaseProduct_.PRICE), min)).orElse(null);
    }

    private static Specification<TvBoxProduct> modelIs(Optional<String> modelName) {
        return (root, query, builder) -> modelName.map(newModel -> builder.equal(
                builder.lower(root.get(BaseProduct_.MODEL_NAME)), newModel.toLowerCase())).orElse(null);
    }

    private static Specification<TvBoxProduct> serialIs(Optional<String> serial) {
        return (root, query, builder) -> serial.map(newSerial -> builder.equal(root.get(BaseProduct_.SERIAL_NUMBER), newSerial)).orElse(null);
    }


    private static Specification<TvBoxProduct> countryIs(Optional<String> producingCountry) {
        return (root, query, builder) -> producingCountry.map(new Function<String, Predicate>() {
            @Override
            public Predicate apply(String country) {
                return builder.equal(root.get(BaseProduct_.PRODUCING_COUNTRY), country);
            }
        }).orElse(null);
    }

    private static Specification<TvBoxProduct> brandIs(Optional<Brand> brandName) {
        return new Specification<TvBoxProduct>() {
            @Override
            public Predicate toPredicate(Root<TvBoxProduct> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
                return brandName.map(new Function<Brand, Predicate>() {
                    @Override
                    public Predicate apply(Brand newBrand) {
                        return builder.equal(root.get(BaseProduct_.BRAND_NAME), newBrand);
                    }
                }).orElse(null);
            }
        };
    }

    private static Specification<TvBoxProduct> colorIs(Optional<Color> colorName) {
        return new Specification<TvBoxProduct>() {
            @Override
            public Predicate toPredicate(Root<TvBoxProduct> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
                return colorName.map(new Function<Color, Predicate>() {
                    @Override
                    public Predicate apply(Color newColor) {
                        return builder.equal(root.get(BaseProduct_.COLOR_NAME), newColor);
                    }
                }).orElse(null);
            }
        };
    }
}