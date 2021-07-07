package com.example.isandstesttask.util.mapper;

import com.example.isandstesttask.entity.BaseProduct;
import com.example.isandstesttask.entity.dto.BaseProductResponseDto;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;

@Getter
@Setter
@Component
public class DtoMapper {
    @Resource
    private ModelMapper modelMapper;
    @Resource
    private BaseProductResponseDto baseProductResponseDto;

    @Autowired
    public DtoMapper(ModelMapper modelMapper, BaseProductResponseDto baseProductResponseDto) {
        this.modelMapper = modelMapper;
        this.modelMapper.addMappings(new PropertyMap<BaseProduct, BaseProductResponseDto>() {
            protected void configure() {
                map().setBrandName(source.getBrandName().getBrandName());
            }
        });
        this.modelMapper.addMappings(new PropertyMap<BaseProduct, BaseProductResponseDto>() {
            protected void configure() {
                map().setColorName(source.getColorName().getColorName());
            }
        });
        this.baseProductResponseDto = baseProductResponseDto;
    }

    public BaseProductResponseDto asDTO(BaseProduct baseProduct) {

        modelMapper.map(baseProduct, baseProductResponseDto);

        return baseProductResponseDto;
    }
}