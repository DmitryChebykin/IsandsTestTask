package com.example.isandstesttask.filter.TvBox;

import com.example.isandstesttask.entity.reference.Product;
import com.example.isandstesttask.filter.TvBox.metamodel.TvBox_;
import org.springframework.data.jpa.domain.Specification;
import java.util.Optional;

public final class TvBoxSpecification {
    private TvBoxSpecification() {
    }

    public static Specification<Product> createTvBoxSpecifications(TvBoxSearchCriteria tvBoxSearchCriteria) {

        Specification<Product> categorySpec = categoryIs(tvBoxSearchCriteria.getCategory());

        Specification<Product> techSpec = technologyIs(tvBoxSearchCriteria.getTechnology());

        return categorySpec.and(techSpec);
    }

    private static Specification<Product> technologyIs(Optional<String> technology) {
        return (root, query, builder) -> technology.map(newTech -> builder.equal(root.get(TvBox_.TECHNOLOGY), newTech)).orElse(null);
    }

    private static Specification<Product> categoryIs(Optional<String> category) {
        return (root, query, builder) -> category.map(newCategory -> builder.equal(root.get(TvBox_.CATEGORY), newCategory)).orElse(null);
    }
}