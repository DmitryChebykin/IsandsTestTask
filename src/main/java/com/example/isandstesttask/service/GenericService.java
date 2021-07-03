package com.example.isandstesttask.service;

import com.example.isandstesttask.entity.BaseProduct;
import com.example.isandstesttask.repository.GenericProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GenericService {
    private GenericProductRepository<BaseProduct> genericProductRepository;

    @Autowired
    public GenericService(GenericProductRepository genericProductRepository) {
        this.genericProductRepository = genericProductRepository;
    }

    public GenericService() {

    }

    public List<BaseProduct> getProductByModelName(String modelName)  {
        return genericProductRepository.findAllByModelNameAllIgnoreCase(modelName).orElseThrow(() -> new ProductRequestException("Can't find products with model name: " + modelName));
    }

    public List<BaseProduct> getProductByProductType(String productType) {
        return genericProductRepository.findAllByProductType(productType)
                .orElseThrow(() -> new ProductRequestException("Can't find products with product type: " + productType));
    }
}