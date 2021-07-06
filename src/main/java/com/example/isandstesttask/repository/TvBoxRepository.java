package com.example.isandstesttask.repository;

import com.example.isandstesttask.entity.product.TvBox;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TvBoxRepository extends JpaRepository<TvBox, UUID>, JpaSpecificationExecutor<TvBox> {
    Optional<TvBox> findBySerialNumber(String serialNumber);

    Optional<TvBox> findBySerialNumberAndModelName(String serialNumber, String modelName);

    List<TvBox> findAll(@Nullable Specification<TvBox> spec);

    List<TvBox> findAll(@Nullable Specification<TvBox> spec, Sort sort);

    Optional<TvBox> findById(UUID id);
}