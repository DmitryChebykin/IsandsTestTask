package com.example.isandstesttask.service.filter;

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

    public static Specification<TvBox> priceBetween(Optional<BigDecimal> minPrice, Optional<BigDecimal> maxPrice) {
        return (root, query, builder) -> {
            return minPrice.map(min -> {
                return maxPrice.map(max -> builder.between(root.get(TvBox_.price), min, max)
                ).orElse(null);
            }).orElse(null);
        };
    }

    public static Specification<TvBox> createTvBoxSpecifications(TvBoxSearchCriteria tvBoxSearchCriteria) {
        Specification<TvBox> colorSpec = colorIs(tvBoxSearchCriteria.getColorName());
        Specification<TvBox> brandSpec = brandIs(tvBoxSearchCriteria.getBrandName());
        Specification<TvBox> categorySpec = categoryIs(tvBoxSearchCriteria.getCategory());
        Specification<TvBox> priceSpec = priceBetween(tvBoxSearchCriteria.getMinPrice(), tvBoxSearchCriteria.getMinPrice());
        Specification<TvBox> modelNameSpec = modelIs(tvBoxSearchCriteria.getModelName());
        Specification<TvBox> countrySpec = countryIs(tvBoxSearchCriteria.getProducingCountry());
        Specification<TvBox> serialSpec = countryIs(tvBoxSearchCriteria.getSerialNumber());

        return priceSpec
                .and(categorySpec)
                .and(countrySpec)
                .and(modelNameSpec)
                .and(colorSpec)
                .and(serialSpec)
                .and(brandSpec);
    }

    private static Specification<TvBox> modelIs(Optional<String> modelName) {
        return (root, query, builder) -> modelName.map(newModel -> builder.equal(
                builder.lower(root.get(TvBox_.MODEL_NAME)), newModel.toLowerCase())).orElse(null);
    }

    private static Specification<TvBox> serialIs(Optional<String> serial) {
        return (root, query, builder) -> serial.map(newSerial -> builder.equal(root.get(TvBox_.MODEL_NAME), newSerial)).orElse(null);
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