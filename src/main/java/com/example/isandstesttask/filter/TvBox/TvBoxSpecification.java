package com.example.isandstesttask.filter.TvBox;

import com.example.isandstesttask.entity.metamodel.TvBox_;
import com.example.isandstesttask.entity.product.TvBox;
import com.example.isandstesttask.entity.reference.Brand;
import com.example.isandstesttask.entity.reference.Color;
import org.springframework.data.jpa.domain.Specification;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.Optional;
import java.util.function.Function;

public final class TvBoxSpecification {
    private TvBoxSpecification() {
    }

    public static Specification<TvBox> createTvBoxSpecifications(TvBoxSearchCriteria tvBoxSearchCriteria) {
        Specification<TvBox> colorSpec = colorIs(tvBoxSearchCriteria.getColorName());
        Specification<TvBox> brandSpec = brandIs(tvBoxSearchCriteria.getBrandName());
        Specification<TvBox> categorySpec = categoryIs(tvBoxSearchCriteria.getCategory());
        Specification<TvBox> sizeSpec = sizeIs(tvBoxSearchCriteria.getSize());
        Specification<TvBox> modelNameSpec = modelIs(tvBoxSearchCriteria.getModelName());
        Specification<TvBox> countrySpec = countryIs(tvBoxSearchCriteria.getProducingCountry());
        Specification<TvBox> serialSpec = serialIs(tvBoxSearchCriteria.getSerialNumber());
        Specification<TvBox> techSpec = technologyIs(tvBoxSearchCriteria.getTechnology());
        Specification<TvBox> minPrice = hasPriceAbove(tvBoxSearchCriteria.getMinPrice());
        Specification<TvBox> maxPrice = hasPriceUnder(tvBoxSearchCriteria.getMaxPrice());

        return minPrice
                .and(maxPrice)
                .and(categorySpec)
                .and(countrySpec)
                .and(modelNameSpec)
                .and(colorSpec)
                .and(serialSpec)
                .and(sizeSpec)
                .and(techSpec)
                .and(brandSpec);
    }

    private static Specification<TvBox> sizeIs(Optional<String> size) {
        return (root, query, builder) -> size.map(newSize -> builder.equal(root.get(TvBox_.SIZE), newSize)).orElse(null);
    }

    public static Specification<TvBox> hasPriceAbove(Optional<BigDecimal> minPrice) {
        return (root, query, builder) -> minPrice.map(min ->
                builder.greaterThanOrEqualTo(root.get(TvBox_.PRICE), min)).orElse(null);
    }

    public static Specification<TvBox> hasPriceUnder(Optional<BigDecimal> maxPrice) {
        return (root, query, builder) -> maxPrice.map(min ->
                builder.lessThanOrEqualTo(root.get(TvBox_.PRICE), min)).orElse(null);
    }

    private static Specification<TvBox> modelIs(Optional<String> modelName) {
        return (root, query, builder) -> modelName.map(newModel -> builder.equal(
                builder.lower(root.get(TvBox_.MODEL_NAME)), newModel.toLowerCase())).orElse(null);
    }

    private static Specification<TvBox> serialIs(Optional<String> serial) {
        return (root, query, builder) -> serial.map(newSerial -> builder.equal(root.get(TvBox_.SERIAL_NUMBER), newSerial)).orElse(null);
    }

    private static Specification<TvBox> technologyIs(Optional<String> technology) {
        return (root, query, builder) -> technology.map(newTech -> builder.equal(root.get(TvBox_.TECHNOLOGY), newTech)).orElse(null);
    }

    private static Specification<TvBox> categoryIs(Optional<String> category) {
        return (root, query, builder) -> category.map(newCategory -> builder.equal(root.get(TvBox_.CATEGORY), newCategory)).orElse(null);
    }

    private static Specification<TvBox> countryIs(Optional<String> producingCountry) {
        return (root, query, builder) -> producingCountry.map(new Function<String, Predicate>() {
            @Override
            public Predicate apply(String country) {
                return builder.equal(root.get(TvBox_.PRODUCING_COUNTRY), country);
            }
        }).orElse(null);
    }

    private static Specification<TvBox> brandIs(Optional<Brand> brandName) {
        return new Specification<TvBox>() {
            @Override
            public Predicate toPredicate(Root<TvBox> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
                return brandName.map(new Function<Brand, Predicate>() {
                    @Override
                    public Predicate apply(Brand newBrand) {
                        return builder.equal(root.get(TvBox_.BRAND_NAME), newBrand);
                    }
                }).orElse(null);
            }
        };
    }

    private static Specification<TvBox> colorIs(Optional<Color> colorName) {
        return new Specification<TvBox>() {
            @Override
            public Predicate toPredicate(Root<TvBox> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
                return colorName.map(new Function<Color, Predicate>() {
                    @Override
                    public Predicate apply(Color newColor) {
                        return builder.equal(root.get(TvBox_.COLOR_NAME), newColor);
                    }
                }).orElse(null);
            }
        };
    }
}