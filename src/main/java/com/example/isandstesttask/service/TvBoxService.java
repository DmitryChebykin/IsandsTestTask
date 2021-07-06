package com.example.isandstesttask.service;

import com.example.isandstesttask.entity.dto.create.TvBoxDto;
import com.example.isandstesttask.entity.dto.response.TvBoxResponseDto;
import com.example.isandstesttask.entity.mapper.GenericMapper;
import com.example.isandstesttask.entity.product.TvBox;
import com.example.isandstesttask.entity.reference.Brand;
import com.example.isandstesttask.entity.reference.Color;
import com.example.isandstesttask.exception.ProductRequestException;
import com.example.isandstesttask.repository.reference.BrandRepository;
import com.example.isandstesttask.repository.reference.ColorRepository;
import com.example.isandstesttask.repository.reference.TvBoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TvBoxService {

    private TvBoxRepository tvBoxRepository;
    private BrandRepository brandRepository;
    private ColorRepository colorRepository;
    @Autowired
    private GenericMapper<TvBox, TvBoxDto> genericMapper;

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

        Optional<Brand> optionalBrand = brandRepository.findByBrandName(tvBox.getBrandName().getBrandName());

        optionalBrand.ifPresent(tvBox::setBrandName);

        Optional<Color> optionalColor = colorRepository.findByColorName(tvBox.getColorName().getColorName());

        optionalColor.ifPresent(tvBox::setColorName);

        tvBox.setProductType(TvBox.PRODUCT_TYPE);

        return tvBoxRepository.save(tvBox).getId().toString();
    }

    public TvBox getProductById(String id) {
        return tvBoxRepository.getById(UUID.fromString(id));
    }

    public List<TvBox> getAll() {
        return tvBoxRepository.findAll();
    }

    public boolean isTvBoxExistsByModelNameAndSAndSerialNumber(String modelName, String serialNumber) {
        return tvBoxRepository.findBySerialNumberAndModelName(serialNumber, modelName).isPresent();
    }

    public TvBox getTvBoxBySerialNumber(String serialNumber) {
        return tvBoxRepository.findBySerialNumber(serialNumber).orElseThrow(() -> new ProductRequestException("Not found product with serial : " + serialNumber));
    }

    public String createTvBox(TvBoxDto tvBoxDto) {
        return createTvBox(genericMapper.asEntity(tvBoxDto));
    }

    public TvBoxResponseDto getResponseDto(TvBox tvBox) {
        return null;
    }
}