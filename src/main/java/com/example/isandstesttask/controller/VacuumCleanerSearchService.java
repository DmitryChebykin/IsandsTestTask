package com.example.isandstesttask.controller;

import com.example.isandstesttask.entity.dto.create.VacuumCleanerCreatingDtoImpl;
import com.example.isandstesttask.entity.reference.Product;
import com.example.isandstesttask.filter.TvBox.ProductSpecification;
import com.example.isandstesttask.filter.TvBox.VacuumCleanerSearchCriteria;
import com.example.isandstesttask.repository.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import java.util.List;

public class VacuumCleanerSearchService {
    private VacuumCleanerSearchCriteria vacuumCleanerSearchCriteria;
    private ProductRepository productRepository;

    @Autowired
    public VacuumCleanerSearchService(VacuumCleanerSearchCriteria vacuumCleanerSearchCriteria, @Qualifier("1") ProductRepository productRepository) {
        this.vacuumCleanerSearchCriteria = vacuumCleanerSearchCriteria;
        this.productRepository = productRepository;
    }

    public List<Product> getUnsortedTvBox(VacuumCleanerSearchCriteria vacuumCleanerSearchCriteria) {
        return null;
    }

    public List<Product> getSortedByNameAscAndPriceDescListTvBox(VacuumCleanerSearchCriteria vacuumCleanerSearchCriteria) {
        Specification<Product> baseSpecification = ProductSpecification.createVacuumCleanerSpecifications(vacuumCleanerSearchCriteria);
        Sort.TypedSort<Product> productTypedSort = Sort.sort(Product.class);
        Sort sort = productTypedSort
                .by(Product::getModelName).ascending()
                .and(productTypedSort.by(Product::getPrice).descending());
        List all = productRepository.findAll(baseSpecification, sort);
        return all;
    }

    public List<VacuumCleanerCreatingDtoImpl> getSortedListByNameAscAndPriceDescOfResponseDto(VacuumCleanerSearchCriteria vacuumCleanerSearchCriteria) {
        return null;
    }
}