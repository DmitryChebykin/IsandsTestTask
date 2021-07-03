package com.example.isandstesttask.repository;

import com.example.isandstesttask.entity.product.TvBox;
import java.util.Optional;

public interface TvBoxRepository extends GenericProductRepository<TvBox> {
    Optional<TvBoxRepository> findByCategory(String category);

    Optional<TvBox> findByTechnology(String technology);

}