package com.example.isandstesttask.service;

import com.example.isandstesttask.entity.BaseProduct;
import com.example.isandstesttask.entity.dto.TvBoxFilterDto;
import com.example.isandstesttask.entity.product.TvBox;
import com.example.isandstesttask.repository.TvBoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import static com.example.isandstesttask.entity.product.TvBox.PRODUCT_TYPE;

@Service
public class TvBoxService extends GenericService {

    private TvBoxRepository tvBoxRepository;

    @Autowired
    public TvBoxService(TvBoxRepository tvBoxRepository) {
        super();
        this.tvBoxRepository = tvBoxRepository;
    }

    public List<BaseProduct> getProductByProductType(String productType) {
        return tvBoxRepository.findAllByProductType(productType)
                .orElseThrow(() -> new ProductRequestException("Can't find products with product type: " + productType));
    }

    public UUID createTelevisionProduct(TvBox televisionProduct) {
        Optional<BaseProduct> optional = tvBoxRepository.existsBySerialNumber(televisionProduct.getSerialNumber());

        if (optional.isPresent()) {
            return optional.get().getId();
        }

        return tvBoxRepository.save(televisionProduct).getId();
    }

    public boolean isTelevisionProductExistsByModelNameAndSAndSerialNumber(String modelName, String serialNumber) {
        return tvBoxRepository.existsByModelNameAndSerialNumber(modelName, serialNumber).isPresent();
    }

    public TvBox getTelevisionProductBySerialNumber(String serialNumber) {
        List<BaseProduct> productList = tvBoxRepository.findBySerialNumber(serialNumber).orElseThrow(() -> new ProductRequestException("Can't find products with product type: " + serialNumber));
        return (TvBox) productList.stream().filter(baseProduct -> baseProduct.getProductType().equals(PRODUCT_TYPE));
    }

    public TvBox getProductById(String id) {
        return tvBoxRepository.getById(UUID.fromString(id));
    }


}