package com.example.isandstesttask.filter.tvbox;

import com.example.isandstesttask.entity.product.TvBoxImpl;
import com.example.isandstesttask.entity.reference.Brand;
import com.example.isandstesttask.entity.reference.Color;
import com.example.isandstesttask.filter.metamodel.BaseProductImpl_;
import com.example.isandstesttask.filter.metamodel.TvBoxImpl_;
import org.springframework.data.jpa.domain.Specification;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.Optional;
import java.util.function.Function;

public final class TvSpecification {
    private TvSpecification() {
    }

    public static Specification<TvBoxImpl> createTvBoxSpecification(TvBoxSearchCriteria tvBoxSearchCriteria) {
        Specification<TvBoxImpl> colorSpec = colorIs(tvBoxSearchCriteria.getColorName());
        Specification<TvBoxImpl> brandSpec = brandIs(tvBoxSearchCriteria.getBrandName());
        Specification<TvBoxImpl> sizeSpec = sizeIs(tvBoxSearchCriteria.getSize());
        Specification<TvBoxImpl> modelNameSpec = modelIs(tvBoxSearchCriteria.getModelName());
        Specification<TvBoxImpl> countrySpec = countryIs(tvBoxSearchCriteria.getProducingCountry());
        Specification<TvBoxImpl> serialSpec = serialIs(tvBoxSearchCriteria.getSerialNumber());
        Specification<TvBoxImpl> minPriceSpec = hasPriceAbove(tvBoxSearchCriteria.getMinPrice());
        Specification<TvBoxImpl> maxPriceSpec = hasPriceUnder(tvBoxSearchCriteria.getMaxPrice());
        Specification<TvBoxImpl> availSpec = availableIs(tvBoxSearchCriteria.getIsAvailable());
        Specification<TvBoxImpl> onlineOrderingSpec = onlineOrderingIs(tvBoxSearchCriteria.getIsOnlineOrdering());
        Specification<TvBoxImpl> soldInstalmentsSpec = soldInstalmentsIs(tvBoxSearchCriteria.getIsSoldByInstallments());
        Specification<TvBoxImpl> categorySpec = categoryIs(tvBoxSearchCriteria.getCategory());
        Specification<TvBoxImpl> techSpec = technologyIs(tvBoxSearchCriteria.getTechnology());

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

    private static Specification<TvBoxImpl> availableIs(Optional<Boolean> isAvailable) {
        return (root, query, builder) -> isAvailable.map(e -> builder.equal(root.get(BaseProductImpl_.AVAILABLE), e)).orElse(null);
    }

    private static Specification<TvBoxImpl> onlineOrderingIs(Optional<Boolean> isOnlineOrdering) {
        return (root, query, builder) -> isOnlineOrdering.map(e -> builder.equal(root.get(BaseProductImpl_.IS_ONLINE_ORDERING), e)).orElse(null);
    }

    private static Specification<TvBoxImpl> soldInstalmentsIs(Optional<Boolean> isSoldByInstallments) {
        return (root, query, builder) -> isSoldByInstallments.map(e -> builder.equal(root.get(BaseProductImpl_.IS_SOLD_BY_INSTALLMENTS), e)).orElse(null);
    }

    private static Specification<TvBoxImpl> sizeIs(Optional<String> size) {
        return (root, query, builder) -> size.map(newSize -> builder.equal(root.get(BaseProductImpl_.SIZE), newSize)).orElse(null);
    }

    public static Specification<TvBoxImpl> hasPriceAbove(Optional<BigDecimal> minPrice) {
        return (root, query, builder) -> minPrice.map(min ->
                builder.greaterThanOrEqualTo(root.get(BaseProductImpl_.PRICE), min)).orElse(null);
    }

    public static Specification<TvBoxImpl> hasPriceUnder(Optional<BigDecimal> maxPrice) {
        return (root, query, builder) -> maxPrice.map(min ->
                builder.lessThanOrEqualTo(root.get(BaseProductImpl_.PRICE), min)).orElse(null);
    }

    private static Specification<TvBoxImpl> modelIs(Optional<String> modelName) {
        return (root, query, builder) -> modelName.map(newModel -> builder.equal(
                builder.lower(root.get(BaseProductImpl_.MODEL_NAME)), newModel.toLowerCase())).orElse(null);
    }

    private static Specification<TvBoxImpl> serialIs(Optional<String> serial) {
        return (root, query, builder) -> serial.map(newSerial -> builder.equal(root.get(BaseProductImpl_.SERIAL_NUMBER), newSerial)).orElse(null);
    }

    private static Specification<TvBoxImpl> countryIs(Optional<String> producingCountry) {
        return (root, query, builder) -> producingCountry.map(new Function<String, Predicate>() {
            @Override
            public Predicate apply(String country) {
                return builder.equal(root.get(BaseProductImpl_.PRODUCING_COUNTRY), country);
            }
        }).orElse(null);
    }

    private static Specification<TvBoxImpl> brandIs(Optional<Brand> brandName) {
        return new Specification<TvBoxImpl>() {
            @Override
            public Predicate toPredicate(Root<TvBoxImpl> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
                return brandName.map(new Function<Brand, Predicate>() {
                    @Override
                    public Predicate apply(Brand newBrand) {
                        return builder.equal(root.get(BaseProductImpl_.BRAND_NAME), newBrand);
                    }
                }).orElse(null);
            }
        };
    }

    private static Specification<TvBoxImpl> colorIs(Optional<Color> colorName) {
        return new Specification<TvBoxImpl>() {
            @Override
            public Predicate toPredicate(Root<TvBoxImpl> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
                return colorName.map(new Function<Color, Predicate>() {
                    @Override
                    public Predicate apply(Color newColor) {
                        return builder.equal(root.get(BaseProductImpl_.COLOR_NAME), newColor);
                    }
                }).orElse(null);
            }
        };
    }

    private static Specification<TvBoxImpl> technologyIs(Optional<String> technology) {
        return (root, query, builder) -> technology.map(newTech -> builder.equal(root.get(TvBoxImpl_.TECHNOLOGY), newTech)).orElse(null);
    }

    private static Specification<TvBoxImpl> categoryIs(Optional<String> category) {
        return (root, query, builder) -> category.map(newCategory -> builder.equal(root.get(TvBoxImpl_.CATEGORY), newCategory)).orElse(null);
    }
}