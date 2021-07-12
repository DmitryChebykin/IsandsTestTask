package com.example.isandstesttask.repository.product;

import com.example.isandstesttask.entity.product.TvBoxImpl;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TvBoxRepository extends JpaRepository<TvBoxImpl, UUID>, JpaSpecificationExecutor<TvBoxImpl> {
    Optional<TvBoxImpl> findBySerialNumber(String serialNumber);

    Optional<TvBoxImpl> findById(UUID id);

    List<TvBoxImpl> findAll(Specification<TvBoxImpl> baseSpecification, Sort sort);
}