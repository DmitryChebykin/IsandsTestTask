package com.example.isandstesttask.service.filter;

import com.example.isandstesttask.entity.metamodel.TvBox_;
import com.example.isandstesttask.entity.product.TvBox;
import org.springframework.data.jpa.domain.Specification;
import java.math.BigDecimal;
import java.util.Optional;

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
        return null;
    }
}