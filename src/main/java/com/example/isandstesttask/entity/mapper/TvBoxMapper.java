package com.example.isandstesttask.entity.mapper;

import com.example.isandstesttask.entity.dto.create.TvBoxCreatingDto;
import com.example.isandstesttask.entity.product.TvBox;
import com.example.isandstesttask.entity.reference.Brand;
import com.example.isandstesttask.entity.reference.Color;
import com.example.isandstesttask.service.TvBoxService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import static com.example.isandstesttask.entity.product.TvBox.PRODUCT_TYPE;

@Component
public class TvBoxMapper implements GenericMapper<TvBox, TvBoxCreatingDto> {
    private ModelMapper modelMapper;
    private TvBoxService tvBoxService;

    public TvBoxMapper() {
    }

    @Autowired
    public TvBoxMapper(ModelMapper modelMapper, TvBoxService tvBoxService) {
        this.modelMapper = modelMapper;
        this.tvBoxService = tvBoxService;
    }

    public TvBox asEntity(TvBoxCreatingDto tvBoxCreatingDto) {
        TvBox tvBox = modelMapper.map(tvBoxCreatingDto, TvBox.class);

        if (tvBoxService.isTvBoxExistsByModelNameAndSAndSerialNumber(tvBoxCreatingDto.getModelName(), tvBoxCreatingDto.getSerialNumber())) {
            tvBox.setId(tvBoxService.getTvBoxBySerialNumber(tvBoxCreatingDto.getSerialNumber()).getId());
        }

        tvBox.setProductType(PRODUCT_TYPE);

        Brand brand = new Brand();
        brand.setBrandName(tvBoxCreatingDto.getBrandName());
        tvBox.setBrandName(brand);

        Color color = new Color();
        color.setColorName(tvBoxCreatingDto.getColorName());
        tvBox.setColorName(color);

        return tvBox;
    }

    public TvBoxCreatingDto asDTO(TvBox tvBox) {
        TvBoxCreatingDto tvBoxCreatingDto = modelMapper.map(tvBox, TvBoxCreatingDto.class);
        tvBoxCreatingDto.setBrandName(tvBox.getBrandName().getBrandName());
        tvBoxCreatingDto.setColorName(tvBox.getColorName().getColorName());
        return modelMapper.map(tvBox, TvBoxCreatingDto.class);
    }
}