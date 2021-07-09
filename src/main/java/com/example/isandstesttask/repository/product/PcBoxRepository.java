package com.example.isandstesttask.repository.product;

import com.example.isandstesttask.test.PcBoxImpl;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PcBoxRepository extends JpaRepository<PcBoxImpl, UUID>, JpaSpecificationExecutor<PcBoxImpl> {
    Optional<PcBoxImpl> findBySerialNumber(String serialNumber);

    List<PcBoxImpl> findAll(Specification<PcBoxImpl> baseSpecification, Sort sort);
}