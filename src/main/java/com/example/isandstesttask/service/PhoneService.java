package com.example.isandstesttask.service;

import com.example.isandstesttask.entity.dto.create.PhoneCreatingDtoImpl;
import com.example.isandstesttask.entity.product.Phone;
import com.example.isandstesttask.entity.product.PhoneImpl;
import com.example.isandstesttask.entity.reference.Brand;
import com.example.isandstesttask.entity.reference.Color;
import com.example.isandstesttask.repository.product.PhoneRepository;
import com.example.isandstesttask.repository.reference.BrandRepository;
import com.example.isandstesttask.repository.reference.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
public class PhoneService {
    @Resource
    private PhoneRepository phoneRepository;
    private BrandRepository brandRepository;
    private ColorRepository colorRepository;

    @Autowired
    public PhoneService(PhoneRepository phoneRepository, BrandRepository brandRepository, ColorRepository colorRepository) {
        this.phoneRepository = phoneRepository;
        this.brandRepository = brandRepository;
        this.colorRepository = colorRepository;
    }

    @Transactional
    public String save(PhoneImpl PhoneImpl) {
        return phoneRepository.save(PhoneImpl).getId().toString();
    }

    @Transactional
    public String createPhone(PhoneImpl PhoneImpl) {
        Optional<PhoneImpl> optionalPhonees = phoneRepository.findBySerialNumber(PhoneImpl.getSerialNumber());

        if (optionalPhonees.isPresent()) {
            return optionalPhonees.get().getId().toString();
        }

        String brandName = PhoneImpl.getBrandName().getBrandName();
        Optional<Brand> optionalBrand = brandRepository.findByBrandName(brandName);

        optionalBrand.ifPresent(PhoneImpl::setBrandName);

        Optional<Color> optionalColor = colorRepository.findByColorName(PhoneImpl.getColorName().getColorName());

        optionalColor.ifPresent(PhoneImpl::setColorName);

        return phoneRepository.save(PhoneImpl).getId().toString();
    }

    public Phone getProductById(String id) {
        return phoneRepository.getById(UUID.fromString(id));
    }

    public String createPhone(PhoneCreatingDtoImpl PhoneCreatingDtoImpl) {
        PhoneImpl PhoneImpl = getPhone(PhoneCreatingDtoImpl);
        return createPhone(PhoneImpl);
    }

    private PhoneImpl getPhone(PhoneCreatingDtoImpl PhoneCreatingDtoImpl) {
        PhoneImpl.PhoneImplBuilder PhoneBuilder = PhoneImpl.PhoneImplBuilder.aPhoneImpl()
                .producingCountry(PhoneCreatingDtoImpl.getProducingCountry())
                .camerasNumber(PhoneCreatingDtoImpl.getCamerasNumber())
                .modelName(PhoneCreatingDtoImpl.getModelName())
                .price(PhoneCreatingDtoImpl.getPrice())
                .serialNumber(PhoneCreatingDtoImpl.getSerialNumber())
                .size(PhoneCreatingDtoImpl.getSize())
                .memorySize(PhoneCreatingDtoImpl.getMemorySize())
                .isOnlineOrdering(PhoneCreatingDtoImpl.getIsOnlineOrdering())
                .isSoldByInstallments(PhoneCreatingDtoImpl.getIsSoldByInstallments())
                .available(PhoneCreatingDtoImpl.getAvailable());

        Brand brand = brandRepository.findByBrandName(PhoneCreatingDtoImpl.getBrandName()).orElseGet(Brand::new);
        brand.setBrandName(PhoneCreatingDtoImpl.getBrandName());
        PhoneBuilder.brandName(brand);

        Color color = colorRepository.findByColorName(PhoneCreatingDtoImpl.getColorName()).orElseGet(Color::new);
        color.setColorName(PhoneCreatingDtoImpl.getColorName());
        PhoneBuilder.colorName(color);

        return PhoneBuilder.build();
    }
}