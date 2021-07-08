package com.example.isandstesttask.service;

import com.example.isandstesttask.entity.dto.create.TvBoxCreatingDtoImpl;
import com.example.isandstesttask.entity.product.interfaces.TvBox;
import com.example.isandstesttask.entity.product.TvBoxImpl;
import com.example.isandstesttask.entity.reference.Brand;
import com.example.isandstesttask.entity.reference.Color;
import com.example.isandstesttask.repository.product.TvBoxRepository;
import com.example.isandstesttask.repository.reference.BrandRepository;
import com.example.isandstesttask.repository.reference.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
public class TvBoxService {
@Resource
    private TvBoxRepository tvBoxRepository;
    private BrandRepository brandRepository;
    private ColorRepository colorRepository;

    @Autowired
    public TvBoxService(TvBoxRepository tvBoxRepository, BrandRepository brandRepository, ColorRepository colorRepository) {
        this.tvBoxRepository = tvBoxRepository;
        this.brandRepository = brandRepository;
        this.colorRepository = colorRepository;
    }

    @Transactional
    public String save(TvBoxImpl tvBoxImpl) {
        return tvBoxRepository.save(tvBoxImpl).getId().toString();
    }

    @Transactional
    public String addTvBox(TvBoxImpl tvBoxImpl) {
        Optional<TvBoxImpl> optionalTvBoxes = tvBoxRepository.findBySerialNumber(tvBoxImpl.getSerialNumber());

        if (optionalTvBoxes.isPresent()) {
            return optionalTvBoxes.get().getId().toString();
        }

        String brandName = tvBoxImpl.getBrandName().getBrandName();
        Optional<Brand> optionalBrand = brandRepository.findByBrandName(brandName);

        optionalBrand.ifPresent(tvBoxImpl::setBrandName);

        Optional<Color> optionalColor = colorRepository.findByColorName(tvBoxImpl.getColorName().getColorName());

        optionalColor.ifPresent(tvBoxImpl::setColorName);

        return tvBoxRepository.save(tvBoxImpl).getId().toString();
    }

    public TvBox getProductById(String id) {
        return tvBoxRepository.getById(UUID.fromString(id));
    }

    public String addTvBox(TvBoxCreatingDtoImpl tvBoxCreatingDtoImpl) {
        TvBoxImpl tvBoxImpl = getTvBox(tvBoxCreatingDtoImpl);
        return addTvBox(tvBoxImpl);
    }

    private TvBoxImpl getTvBox(TvBoxCreatingDtoImpl tvBoxCreatingDtoImpl) {
        TvBoxImpl.TvBoxBuilder tvBoxBuilder = TvBoxImpl.TvBoxBuilder.aTvBox()
                .producingCountry(tvBoxCreatingDtoImpl.getProducingCountry())
                .category(tvBoxCreatingDtoImpl.getCategory())
                .modelName(tvBoxCreatingDtoImpl.getModelName())
                .price(tvBoxCreatingDtoImpl.getPrice())
                .serialNumber(tvBoxCreatingDtoImpl.getSerialNumber())
                .size(tvBoxCreatingDtoImpl.getSize())
                .technology(tvBoxCreatingDtoImpl.getTechnology())
                .isOnlineOrdering(tvBoxCreatingDtoImpl.getIsOnlineOrdering())
                .isSoldByInstallments(tvBoxCreatingDtoImpl.getIsSoldByInstallments())
                .available(tvBoxCreatingDtoImpl.getAvailable());

        Brand brand = brandRepository.findByBrandName(tvBoxCreatingDtoImpl.getBrandName()).orElseGet(Brand::new);
        brand.setBrandName(tvBoxCreatingDtoImpl.getBrandName());
        tvBoxBuilder.brandName(brand);

        Color color = colorRepository.findByColorName(tvBoxCreatingDtoImpl.getColorName()).orElseGet(Color::new);
        color.setColorName(tvBoxCreatingDtoImpl.getColorName());
        tvBoxBuilder.colorName(color);

        TvBoxImpl tvBox = tvBoxBuilder.build();
        return tvBox;
    }
}