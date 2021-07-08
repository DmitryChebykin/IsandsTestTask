package com.example.isandstesttask.util.mapper;

import com.example.isandstesttask.entity.BaseProduct;
import com.example.isandstesttask.entity.TvBoxProduct;
import com.example.isandstesttask.entity.dto.BaseProductResponseDto;
import com.example.isandstesttask.entity.dto.response.TvBoxResponseDtoImpl;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Getter
@Setter
@Service
public class TvBoxDtoMapper {
    private ModelMapper modelMapper;

    @Autowired
    public TvBoxDtoMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.modelMapper.addMappings(new PropertyMap<TvBoxProduct, BaseProductResponseDto>() {
            protected void configure() {
                map().setBrandName(source.getBrandName().getBrandName());
            }
        });
        this.modelMapper.addMappings(new PropertyMap<BaseProduct, BaseProductResponseDto>() {
            protected void configure() {
                map().setColorName(source.getColorName().getColorName());
            }
        });
    }

    public TvBoxResponseDtoImpl asDTO(TvBoxProduct tvBoxProduct) {
        TvBoxResponseDtoImpl tvBoxResponseDto = new TvBoxResponseDtoImpl();

        modelMapper.map(tvBoxProduct, tvBoxResponseDto);

        return tvBoxResponseDto;
    }
}