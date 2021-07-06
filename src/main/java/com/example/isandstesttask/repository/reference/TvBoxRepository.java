package com.example.isandstesttask.repository.reference;

import com.example.isandstesttask.entity.product.TvBox;
import com.example.isandstesttask.repository.GenericProductRepository;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TvBoxRepository extends GenericProductRepository<TvBox> {
    Optional<TvBox> findBySerialNumber(String serialNumber);

    Optional<TvBox> findBySerialNumberAndModelName(String serialNumber, String modelName);

    List<TvBox> findAll(@Nullable Specification<TvBox> spec);

    List<TvBox> findAll(@Nullable Specification<TvBox> spec, Sort sort);

    Optional<TvBox> findById(UUID id);

    Optional<List<TvBox>> findByAvailableTrue();
}