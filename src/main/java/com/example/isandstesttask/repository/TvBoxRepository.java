package com.example.isandstesttask.repository;

import com.example.isandstesttask.entity.product.TvBox;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TvBoxRepository extends GenericProductRepository<TvBox> {
    Optional<TvBox> findBySerialNumber(String serialNumber);

    Optional<TvBox> findBySerialNumberAndModelName(String serialNumber, String modelName);

    List<TvBox> findAll(@Nullable Specification<TvBox> spec);

    Optional<TvBox> findById(UUID id);
}