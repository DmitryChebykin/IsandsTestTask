package com.example.isandstesttask.repository.product;

import com.example.isandstesttask.entity.product.TvBoxImpl;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface TvBoxRepository extends ProductRepository<TvBoxImpl> {
    Optional<TvBoxImpl> findBySerialNumber(String serialNumber);

    List<TvBoxImpl> findAll(Specification<TvBoxImpl> baseSpecification, Sort sort);
}