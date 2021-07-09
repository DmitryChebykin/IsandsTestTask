package com.example.isandstesttask.service;

import com.example.isandstesttask.entity.reference.Brand;
import com.example.isandstesttask.entity.reference.Color;
import com.example.isandstesttask.repository.reference.BrandRepository;
import com.example.isandstesttask.repository.reference.ColorRepository;
import com.example.isandstesttask.entity.product.PcBox;
import com.example.isandstesttask.entity.dto.create.PcBoxCreatingDtoImpl;
import com.example.isandstesttask.test.PcBoxImpl;
import com.example.isandstesttask.repository.product.PcBoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
public class PcBoxService {
@Resource
    private com.example.isandstesttask.repository.product.PcBoxRepository PcBoxRepository;
    private BrandRepository brandRepository;
    private ColorRepository colorRepository;

    @Autowired
    public PcBoxService(PcBoxRepository PcBoxRepository, BrandRepository brandRepository, ColorRepository colorRepository) {
        this.PcBoxRepository = PcBoxRepository;
        this.brandRepository = brandRepository;
        this.colorRepository = colorRepository;
    }

    @Transactional
    public String save(PcBoxImpl PcBoxImpl) {
        return PcBoxRepository.save(PcBoxImpl).getId().toString();
    }

    @Transactional
    public String createPcBox(PcBoxImpl PcBoxImpl) {
        Optional<PcBoxImpl> optionalPcBoxes = PcBoxRepository.findBySerialNumber(PcBoxImpl.getSerialNumber());

        if (optionalPcBoxes.isPresent()) {
            return optionalPcBoxes.get().getId().toString();
        }

        String brandName = PcBoxImpl.getBrandName().getBrandName();
        Optional<Brand> optionalBrand = brandRepository.findByBrandName(brandName);

        optionalBrand.ifPresent(PcBoxImpl::setBrandName);

        Optional<Color> optionalColor = colorRepository.findByColorName(PcBoxImpl.getColorName().getColorName());

        optionalColor.ifPresent(PcBoxImpl::setColorName);

        return PcBoxRepository.save(PcBoxImpl).getId().toString();
    }

    public PcBox getProductById(String id) {
        return PcBoxRepository.getById(UUID.fromString(id));
    }

    public String createPcBox(PcBoxCreatingDtoImpl PcBoxCreatingDtoImpl) {
        PcBoxImpl PcBoxImpl = getPcBox(PcBoxCreatingDtoImpl);
        return createPcBox(PcBoxImpl);
    }

    private PcBoxImpl getPcBox(PcBoxCreatingDtoImpl PcBoxCreatingDtoImpl) {
        PcBoxImpl.PcBoxImplBuilder PcBoxBuilder = PcBoxImpl.PcBoxImplBuilder.aPcBoxImpl()
                .producingCountry(PcBoxCreatingDtoImpl.getProducingCountry())
                .category(PcBoxCreatingDtoImpl.getCategory())
                .modelName(PcBoxCreatingDtoImpl.getModelName())
                .price(PcBoxCreatingDtoImpl.getPrice())
                .serialNumber(PcBoxCreatingDtoImpl.getSerialNumber())
                .size(PcBoxCreatingDtoImpl.getSize())
                .processorType(PcBoxCreatingDtoImpl.getProcessorType())
                .isOnlineOrdering(PcBoxCreatingDtoImpl.getIsOnlineOrdering())
                .isSoldByInstallments(PcBoxCreatingDtoImpl.getIsSoldByInstallments())
                .available(PcBoxCreatingDtoImpl.getAvailable());

        Brand brand = brandRepository.findByBrandName(PcBoxCreatingDtoImpl.getBrandName()).orElseGet(Brand::new);
        brand.setBrandName(PcBoxCreatingDtoImpl.getBrandName());
        PcBoxBuilder.brandName(brand);

        Color color = colorRepository.findByColorName(PcBoxCreatingDtoImpl.getColorName()).orElseGet(Color::new);
        color.setColorName(PcBoxCreatingDtoImpl.getColorName());
        PcBoxBuilder.colorName(color);

        return PcBoxBuilder.build();
    }
}