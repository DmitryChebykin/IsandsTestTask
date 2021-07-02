package com.example.isandstesttask.entity.mapper;


import com.example.isandstesttask.entity.dto.TelevisionProductDto;
import com.example.isandstesttask.entity.product.TelevisionProduct;
import com.example.isandstesttask.service.TelevisionProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import static com.example.isandstesttask.entity.product.TelevisionProduct.PRODUCT_TYPE;

@Component
public class TelevisionProductMapper implements GenericMapper<TelevisionProduct, TelevisionProductDto>{
    private ModelMapper modelMapper;
    private TelevisionProductService televisionProductService;

    public TelevisionProductMapper() {
    }
    @Autowired
    public TelevisionProductMapper(ModelMapper modelMapper, TelevisionProductService televisionProductService) {
        this.modelMapper = modelMapper;
        this.televisionProductService = televisionProductService;
    }

    public TelevisionProductDto asDTO(TelevisionProduct televisionProduct) {
        return modelMapper.map(televisionProduct, TelevisionProductDto.class);
    }

    public TelevisionProduct asEntity(TelevisionProductDto televisionProductDto) {
        TelevisionProduct televisionProduct = modelMapper.map(televisionProductDto, TelevisionProduct.class);
        if (televisionProductDto.getId() == null) {
            if (televisionProductService.isTelevisionProductExistsByModelNameAndSAndSerialNumber(televisionProductDto.getModelName(), televisionProductDto.getSerialNumber())) {
                televisionProduct.setId(televisionProductService.getTelevisionProductBySerialNumber(televisionProductDto.getSerialNumber()).getId());
            }
        }
        televisionProduct.setProductType(PRODUCT_TYPE);
        return televisionProduct;
    }
}