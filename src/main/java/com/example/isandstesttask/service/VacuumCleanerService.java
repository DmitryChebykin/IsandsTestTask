package com.example.isandstesttask.service;

import com.example.isandstesttask.entity.dto.create.VacuumCleanerCreatingDtoImpl;
import com.example.isandstesttask.entity.product.VacuumCleanerImpl;
import com.example.isandstesttask.entity.reference.Brand;
import com.example.isandstesttask.entity.reference.Color;
import com.example.isandstesttask.repository.product.VacuumCleanerRepository;
import com.example.isandstesttask.repository.reference.BrandRepository;
import com.example.isandstesttask.repository.reference.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
public class VacuumCleanerService {
    @Resource
    private VacuumCleanerRepository vacuumCleanerRepository;
    private BrandRepository brandRepository;
    private ColorRepository colorRepository;

    @Autowired
    public VacuumCleanerService(VacuumCleanerRepository vacuumCleanerRepository, BrandRepository brandRepository, ColorRepository colorRepository) {
        this.vacuumCleanerRepository = vacuumCleanerRepository;
        this.brandRepository = brandRepository;
        this.colorRepository = colorRepository;
    }

    @Transactional
    public String save(VacuumCleanerImpl vacuumCleaner) {
        return vacuumCleanerRepository.save(vacuumCleaner).getId().toString();
    }

    @Transactional
    public String addVacuumCleaner(VacuumCleanerImpl vacuumCleanerImpl) {
        Optional<VacuumCleanerImpl> optionalTvBoxes = vacuumCleanerRepository.findBySerialNumber(vacuumCleanerImpl.getSerialNumber());

        if (optionalTvBoxes.isPresent()) {
            return optionalTvBoxes.get().getId().toString();
        }

        String brandName = vacuumCleanerImpl.getBrandName().getBrandName();
        Optional<Brand> optionalBrand = brandRepository.findByBrandName(brandName);

        optionalBrand.ifPresent(vacuumCleanerImpl::setBrandName);

        Optional<Color> optionalColor = colorRepository.findByColorName(vacuumCleanerImpl.getColorName().getColorName());

        optionalColor.ifPresent(vacuumCleanerImpl::setColorName);

        return vacuumCleanerRepository.save(vacuumCleanerImpl).getId().toString();
    }

    public VacuumCleanerImpl getProductById(String id) {
        return vacuumCleanerRepository.getById(UUID.fromString(id));
    }

    public String addVacuumCleaner(VacuumCleanerCreatingDtoImpl vacuumCleanerCreatingDtoImpl) {
        VacuumCleanerImpl vacuumCleanerImpl = getTvBox(vacuumCleanerCreatingDtoImpl);
        return addVacuumCleaner(vacuumCleanerImpl);
    }

    private VacuumCleanerImpl getTvBox(VacuumCleanerCreatingDtoImpl vacuumCleanerCreatingDtoImpl) {
        VacuumCleanerImpl.VacuumCleanerImplBuilder vacuumCleanerImplBuilder = VacuumCleanerImpl.VacuumCleanerImplBuilder.aVacuumCleanerImpl()
                .producingCountry(vacuumCleanerCreatingDtoImpl.getProducingCountry())
                .DustContainerVolume(vacuumCleanerCreatingDtoImpl.getDustContainerVolume())
                .modelName(vacuumCleanerCreatingDtoImpl.getModelName())
                .price(vacuumCleanerCreatingDtoImpl.getPrice())
                .serialNumber(vacuumCleanerCreatingDtoImpl.getSerialNumber())
                .size(vacuumCleanerCreatingDtoImpl.getSize())
                .ModesNumber(vacuumCleanerCreatingDtoImpl.getModesNumber())
                .isOnlineOrdering(vacuumCleanerCreatingDtoImpl.getIsOnlineOrdering())
                .isSoldByInstallments(vacuumCleanerCreatingDtoImpl.getIsSoldByInstallments())
                .available(vacuumCleanerCreatingDtoImpl.getAvailable());

        Brand brand = brandRepository.findByBrandName(vacuumCleanerCreatingDtoImpl.getBrandName()).orElseGet(Brand::new);
        brand.setBrandName(vacuumCleanerCreatingDtoImpl.getBrandName());
        vacuumCleanerImplBuilder.brandName(brand);

        Color color = colorRepository.findByColorName(vacuumCleanerCreatingDtoImpl.getColorName()).orElseGet(Color::new);
        color.setColorName(vacuumCleanerCreatingDtoImpl.getColorName());
        vacuumCleanerImplBuilder.colorName(color);

        return vacuumCleanerImplBuilder.build();
    }
}