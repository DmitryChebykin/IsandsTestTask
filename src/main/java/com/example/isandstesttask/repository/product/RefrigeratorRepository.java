package com.example.isandstesttask.repository.product;

import com.example.isandstesttask.test.RefrigeratorImpl;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface RefrigeratorRepository extends JpaRepository<RefrigeratorImpl, UUID>, JpaSpecificationExecutor<RefrigeratorImpl> {
    Optional<RefrigeratorImpl> findBySerialNumber(String serialNumber);

    List<RefrigeratorImpl> findAll(Specification<RefrigeratorImpl> baseSpecification, Sort sort);
}