package com.example.isandstesttask.test;

import com.example.isandstesttask.entity.reference.Brand;
import com.example.isandstesttask.entity.reference.Color;
import com.example.isandstesttask.repository.reference.BrandRepository;
import com.example.isandstesttask.repository.reference.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
public class RefrigeratorService {
@Resource
    private RefrigeratorRepository refrigeratorRepository;
    private BrandRepository brandRepository;
    private ColorRepository colorRepository;

    @Autowired
    public RefrigeratorService(RefrigeratorRepository refrigeratorRepository, BrandRepository brandRepository, ColorRepository colorRepository) {
        this.refrigeratorRepository = refrigeratorRepository;
        this.brandRepository = brandRepository;
        this.colorRepository = colorRepository;
    }

    @Transactional
    public String save(RefrigeratorImpl refrigeratorImpl) {
        return refrigeratorRepository.save(refrigeratorImpl).getId().toString();
    }

    @Transactional
    public String createRefrigerator(RefrigeratorImpl refrigeratorImpl) {
        Optional<RefrigeratorImpl> optionalRefrigeratores = refrigeratorRepository.findBySerialNumber(refrigeratorImpl.getSerialNumber());

        if (optionalRefrigeratores.isPresent()) {
            return optionalRefrigeratores.get().getId().toString();
        }

        String brandName = refrigeratorImpl.getBrandName().getBrandName();
        Optional<Brand> optionalBrand = brandRepository.findByBrandName(brandName);

        optionalBrand.ifPresent(refrigeratorImpl::setBrandName);

        Optional<Color> optionalColor = colorRepository.findByColorName(refrigeratorImpl.getColorName().getColorName());

        optionalColor.ifPresent(refrigeratorImpl::setColorName);

        return refrigeratorRepository.save(refrigeratorImpl).getId().toString();
    }

    public Refrigerator getProductById(String id) {
        return refrigeratorRepository.getById(UUID.fromString(id));
    }

    public String createRefrigerator(RefrigeratorCreatingDtoImpl refrigeratorCreatingDtoImpl) {
        RefrigeratorImpl refrigeratorImpl = getRefrigerator(refrigeratorCreatingDtoImpl);
        return createRefrigerator(refrigeratorImpl);
    }

    private RefrigeratorImpl getRefrigerator(RefrigeratorCreatingDtoImpl refrigeratorCreatingDtoImpl) {
        RefrigeratorImpl.RefrigeratorBuilder refrigeratorBuilder = RefrigeratorImpl.RefrigeratorBuilder.aRefrigerator()
                .producingCountry(refrigeratorCreatingDtoImpl.getProducingCountry())
                .category(refrigeratorCreatingDtoImpl.getCategory())
                .modelName(refrigeratorCreatingDtoImpl.getModelName())
                .price(refrigeratorCreatingDtoImpl.getPrice())
                .serialNumber(refrigeratorCreatingDtoImpl.getSerialNumber())
                .size(refrigeratorCreatingDtoImpl.getSize())
                .technology(refrigeratorCreatingDtoImpl.getTechnology())
                .isOnlineOrdering(refrigeratorCreatingDtoImpl.getIsOnlineOrdering())
                .isSoldByInstallments(refrigeratorCreatingDtoImpl.getIsSoldByInstallments())
                .available(refrigeratorCreatingDtoImpl.getAvailable());

        Brand brand = brandRepository.findByBrandName(refrigeratorCreatingDtoImpl.getBrandName()).orElseGet(Brand::new);
        brand.setBrandName(refrigeratorCreatingDtoImpl.getBrandName());
        refrigeratorBuilder.brandName(brand);

        Color color = colorRepository.findByColorName(refrigeratorCreatingDtoImpl.getColorName()).orElseGet(Color::new);
        color.setColorName(refrigeratorCreatingDtoImpl.getColorName());
        refrigeratorBuilder.colorName(color);

        return refrigeratorBuilder.build();
    }
}