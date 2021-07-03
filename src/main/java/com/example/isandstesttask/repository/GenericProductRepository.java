package com.example.isandstesttask.repository;

import com.example.isandstesttask.entity.BaseProduct;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@NoRepositoryBean
public interface GenericProductRepository<E extends BaseProduct> extends JpaRepository<E, UUID> {
    Optional<List<BaseProduct>> findAllByModelNameAllIgnoreCase(String modelName);

    Optional<List<BaseProduct>> findAllByProductType(String productType);

    Optional<List<BaseProduct>> findAllByColorName(String colorName);

    Optional<List<BaseProduct>> findAllByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice, Sort sort);

    Optional<List<BaseProduct>> existsByModelNameAndSerialNumber(String modelName, String serialNumber);

    Optional<List<BaseProduct>> findBySerialNumber(String serialNumber);

    Optional<List<BaseProduct>> findByAvailableTrue();

    Optional<BaseProduct> existsBySerialNumber(String serialNumber);
}