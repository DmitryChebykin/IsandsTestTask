package com.example.isandstesttask.service;

import com.example.isandstesttask.entity.BaseProduct;
import com.example.isandstesttask.entity.product.TelevisionProduct;
import com.example.isandstesttask.repository.TelevisionProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import static com.example.isandstesttask.entity.product.TelevisionProduct.PRODUCT_TYPE;

@Service
public class TelevisionProductService extends  GenericService{

    private TelevisionProductRepository televisionProductRepository;

    @Autowired
    public TelevisionProductService(TelevisionProductRepository televisionProductRepository) {
        super();
        this.televisionProductRepository = televisionProductRepository;
    }

    public List<BaseProduct> getProductByProductType(String productType) {
        return televisionProductRepository.findAllByProductType(productType)
                .orElseThrow(() -> new ProductNotFoundException("Can't find products with product type: " + productType));
    }

    public UUID createTelevisionProduct(TelevisionProduct televisionProduct) {
        return televisionProductRepository.save(televisionProduct).getId();
    }

    public boolean isTelevisionProductExistsByModelNameAndSAndSerialNumber(String modelName, String serialNumber) {
        return televisionProductRepository.existsByModelNameAndSerialNumber(modelName, serialNumber).isPresent();
    }

    public TelevisionProduct getTelevisionProductBySerialNumber(String serialNumber) {
        List<BaseProduct> productList = televisionProductRepository.findBySerialNumber(serialNumber).orElseThrow(() -> new ProductNotFoundException("Can't find products with product type: " + serialNumber));
        return (TelevisionProduct) productList.stream().filter(baseProduct -> baseProduct.getProductType().equals(PRODUCT_TYPE));
    }

    public TelevisionProduct getProductById(String id) {
        return televisionProductRepository.getById(UUID.fromString(id));
    }
}