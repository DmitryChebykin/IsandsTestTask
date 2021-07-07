package com.example.isandstesttask.service;

import com.example.isandstesttask.entity.reference.Brand;
import com.example.isandstesttask.repository.reference.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service
public class BrandService {
    @Resource
    private BrandRepository brandRepository;

    @Autowired
    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public Brand getBrandByName(String brandName) {
        return brandRepository.findByBrandName(brandName).orElse(null);
    }
}