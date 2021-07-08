package com.example.isandstesttask.repository.product;

import com.example.isandstesttask.entity.product.VacuumCleanerImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface VacuumCleanerRepository extends JpaRepository<VacuumCleanerImpl, UUID>, JpaSpecificationExecutor<VacuumCleanerImpl> {

    Optional<VacuumCleanerImpl> findBySerialNumber(String serialNumber);
}