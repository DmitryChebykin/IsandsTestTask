package com.example.isandstesttask.repository.reference;

import com.example.isandstesttask.entity.reference.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface BrandRepository extends JpaRepository<Brand, UUID> {
    Optional<Brand> findByBrandName(String brandName);
}