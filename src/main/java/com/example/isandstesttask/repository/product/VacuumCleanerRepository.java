package com.example.isandstesttask.repository.product;

import com.example.isandstesttask.entity.product.VacuumCleanerImpl;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface VacuumCleanerRepository extends ProductRepository<VacuumCleanerImpl> {
    Optional<VacuumCleanerImpl> findBySerialNumber(String serialNumber);
}