package com.example.isandstesttask.service;

import com.example.isandstesttask.entity.dto.create.TvBoxCreatingDtoImpl;
import com.example.isandstesttask.entity.product.TvBox;
import com.example.isandstesttask.entity.reference.Brand;
import com.example.isandstesttask.entity.reference.Color;
import com.example.isandstesttask.repository.product.TvBoxRepository;
import com.example.isandstesttask.repository.reference.BrandRepository;
import com.example.isandstesttask.repository.reference.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
public class TvBoxService {

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
    public String save(TvBox tvBox) {
        return tvBoxRepository.save(tvBox).getId().toString();
    }

    @Transactional
    public String createTvBox(TvBox tvBox) {
        Optional<TvBox> optionalTvBoxes = tvBoxRepository.findBySerialNumber(tvBox.getSerialNumber());

        if (optionalTvBoxes.isPresent()) {
            return optionalTvBoxes.get().getId().toString();
        }

        String brandName = tvBox.getBrandName().getBrandName();
        Optional<Brand> optionalBrand = brandRepository.findByBrandName(brandName);

        optionalBrand.ifPresent(tvBox::setBrandName);

        Optional<Color> optionalColor = colorRepository.findByColorName(tvBox.getColorName().getColorName());

        optionalColor.ifPresent(tvBox::setColorName);

        return tvBoxRepository.save(tvBox).getId().toString();
    }

    public TvBox getProductById(String id) {
        return tvBoxRepository.getById(UUID.fromString(id));
    }

    public String createTvBox(TvBoxCreatingDtoImpl tvBoxCreatingDtoImpl) {
        TvBox tvBox = getTvBox(tvBoxCreatingDtoImpl);
        return createTvBox(tvBox);
    }

    private TvBox getTvBox(TvBoxCreatingDtoImpl tvBoxCreatingDtoImpl) {
        TvBox.TvBoxBuilder tvBoxBuilder = TvBox.TvBoxBuilder.aTvBox()
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

        TvBox tvBox = tvBoxBuilder.build();
        return tvBox;
    }
}