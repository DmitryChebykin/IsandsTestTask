package com.example.isandstesttask.repository.product;

import com.example.isandstesttask.entity.product.PhoneImpl;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PhoneRepository extends JpaRepository<PhoneImpl, UUID>, JpaSpecificationExecutor<PhoneImpl> {
    Optional<PhoneImpl> findBySerialNumber(String serialNumber);

    List<PhoneImpl> findAll(Specification<PhoneImpl> baseSpecification, Sort sort);
}