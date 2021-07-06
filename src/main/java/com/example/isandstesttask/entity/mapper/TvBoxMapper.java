package com.example.isandstesttask.entity.mapper;

import com.example.isandstesttask.entity.dto.create.TvBoxDto;
import com.example.isandstesttask.entity.product.TvBox;
import com.example.isandstesttask.entity.reference.Brand;
import com.example.isandstesttask.entity.reference.Color;
import com.example.isandstesttask.service.TvBoxService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import static com.example.isandstesttask.entity.product.TvBox.PRODUCT_TYPE;

@Component
public class TvBoxMapper implements GenericMapper<TvBox, TvBoxDto> {
    private ModelMapper modelMapper;
    private TvBoxService tvBoxService;


    public TvBoxMapper() {
    }

    @Autowired
    public TvBoxMapper(ModelMapper modelMapper, TvBoxService tvBoxService) {
        this.modelMapper = modelMapper;
        this.tvBoxService = tvBoxService;
    }

    public TvBox asEntity(TvBoxDto tvBoxDto) {
        TvBox tvBox = modelMapper.map(tvBoxDto, TvBox.class);

        tvBox.setProductType(PRODUCT_TYPE);

        Brand brand = new Brand();
        brand.setBrandName(tvBoxDto.getBrandName());
        tvBox.setBrandName(brand);

        Color color = new Color();
        color.setColorName(tvBoxDto.getColorName());
        tvBox.setColorName(color);

        return tvBox;
    }

    public TvBoxDto asDTO(TvBox tvBox) {
        TvBoxDto tvBoxDto = modelMapper.map(tvBox, TvBoxDto.class);
        tvBoxDto.setBrandName(tvBox.getBrandName().getBrandName());
        tvBoxDto.setColorName(tvBox.getColorName().getColorName());
        return modelMapper.map(tvBox, TvBoxDto.class);
    }
}