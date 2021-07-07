package com.example.isandstesttask.filter.TvBox;

import com.example.isandstesttask.entity.reference.Brand;
import com.example.isandstesttask.entity.reference.Color;
import com.example.isandstesttask.entity.reference.Product;
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

    public static Specification<Product> createTvBoxSpecifications(BaseSearchCriteria baseSearchCriteria) {
        Specification<Product> colorSpec = colorIs(baseSearchCriteria.getColorName());
        Specification<Product> brandSpec = brandIs(baseSearchCriteria.getBrandName());
        Specification<Product> sizeSpec = sizeIs(baseSearchCriteria.getSize());
        Specification<Product> modelNameSpec = modelIs(baseSearchCriteria.getModelName());
        Specification<Product> countrySpec = countryIs(baseSearchCriteria.getProducingCountry());
        Specification<Product> serialSpec = serialIs(baseSearchCriteria.getSerialNumber());
        Specification<Product> minPriceSpec = hasPriceAbove(baseSearchCriteria.getMinPrice());
        Specification<Product> maxPriceSpec = hasPriceUnder(baseSearchCriteria.getMaxPrice());
        Specification<Product> availSpec = availableIs(baseSearchCriteria.getIsAvailable());
        Specification<Product> onlineOrderingSpec = onlineOrderingIs(baseSearchCriteria.getIsOnlineOrdering());
        Specification<Product> soldInstalmentsSpec = soldInstalmentsIs(baseSearchCriteria.getIsSoldByInstallments());

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

    private static Specification<Product> availableIs(Optional<Boolean> isAvailable) {
        return (root, query, builder) -> isAvailable.map(e -> builder.equal(root.get(BaseProduct_.AVAILABLE), e)).orElse(null);
    }

    private static Specification<Product> onlineOrderingIs(Optional<Boolean> isOnlineOrdering) {
        return (root, query, builder) -> isOnlineOrdering.map(e -> builder.equal(root.get(BaseProduct_.IS_ONLINE_ORDERING), e)).orElse(null);
    }

    private static Specification<Product> soldInstalmentsIs(Optional<Boolean> isSoldByInstallments) {
        return (root, query, builder) -> isSoldByInstallments.map(e -> builder.equal(root.get(BaseProduct_.IS_SOLD_BY_INSTALLMENTS), e)).orElse(null);
    }

    private static Specification<Product> sizeIs(Optional<String> size) {
        return (root, query, builder) -> size.map(newSize -> builder.equal(root.get(BaseProduct_.SIZE), newSize)).orElse(null);
    }

    public static Specification<Product> hasPriceAbove(Optional<BigDecimal> minPrice) {
        return (root, query, builder) -> minPrice.map(min ->
                builder.greaterThanOrEqualTo(root.get(BaseProduct_.PRICE), min)).orElse(null);
    }

    public static Specification<Product> hasPriceUnder(Optional<BigDecimal> maxPrice) {
        return (root, query, builder) -> maxPrice.map(min ->
                builder.lessThanOrEqualTo(root.get(BaseProduct_.PRICE), min)).orElse(null);
    }

    private static Specification<Product> modelIs(Optional<String> modelName) {
        return (root, query, builder) -> modelName.map(newModel -> builder.equal(
                builder.lower(root.get(BaseProduct_.MODEL_NAME)), newModel.toLowerCase())).orElse(null);
    }

    private static Specification<Product> serialIs(Optional<String> serial) {
        return (root, query, builder) -> serial.map(newSerial -> builder.equal(root.get(BaseProduct_.SERIAL_NUMBER), newSerial)).orElse(null);
    }


    private static Specification<Product> countryIs(Optional<String> producingCountry) {
        return (root, query, builder) -> producingCountry.map(new Function<String, Predicate>() {
            @Override
            public Predicate apply(String country) {
                return builder.equal(root.get(BaseProduct_.PRODUCING_COUNTRY), country);
            }
        }).orElse(null);
    }

    private static Specification<Product> brandIs(Optional<Brand> brandName) {
        return new Specification<Product>() {
            @Override
            public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
                return brandName.map(new Function<Brand, Predicate>() {
                    @Override
                    public Predicate apply(Brand newBrand) {
                        return builder.equal(root.get(BaseProduct_.BRAND_NAME), newBrand);
                    }
                }).orElse(null);
            }
        };
    }

    private static Specification<Product> colorIs(Optional<Color> colorName) {
        return new Specification<Product>() {
            @Override
            public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
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