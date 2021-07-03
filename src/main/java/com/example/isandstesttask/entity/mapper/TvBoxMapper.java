package com.example.isandstesttask.entity.mapper;


import com.example.isandstesttask.entity.dto.TvBoxDto;
import com.example.isandstesttask.entity.product.TvBox;
import com.example.isandstesttask.service.TvBoxService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import static com.example.isandstesttask.entity.product.TvBox.PRODUCT_TYPE;

@Component
public class TvBoxMapper implements GenericMapper<TvBox, TvBoxDto>{
    private ModelMapper modelMapper;
    private TvBoxService tvBoxService;

    public TvBoxMapper() {
    }
    @Autowired
    public TvBoxMapper(ModelMapper modelMapper, TvBoxService tvBoxService) {
        this.modelMapper = modelMapper;
        this.tvBoxService = tvBoxService;
    }

    public TvBoxDto asDTO(TvBox televisionProduct) {
        return modelMapper.map(televisionProduct, TvBoxDto.class);
    }

    public TvBox asEntity(TvBoxDto tvBoxDto) {
        TvBox televisionProduct = modelMapper.map(tvBoxDto, TvBox.class);
        if (tvBoxDto.getId() == null) {
            if (tvBoxService.isTelevisionProductExistsByModelNameAndSAndSerialNumber(tvBoxDto.getModelName(), tvBoxDto.getSerialNumber())) {
                televisionProduct.setId(tvBoxService.getTelevisionProductBySerialNumber(tvBoxDto.getSerialNumber()).getId());
            }
        }
        televisionProduct.setProductType(PRODUCT_TYPE);
        return televisionProduct;
    }
}