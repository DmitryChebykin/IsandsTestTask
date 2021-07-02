package com.example.isandstesttask.repository;

import com.example.isandstesttask.entity.product.TelevisionProduct;
import java.util.List;
import java.util.Optional;

public interface TelevisionProductRepository extends GenericProductRepository<TelevisionProduct> {
    Optional<TelevisionProductRepository> findByCategory(String category);

    Optional<TelevisionProduct> findByTechnology(String technology);

}