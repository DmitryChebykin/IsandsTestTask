package com.example.isandstesttask.entity.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import java.math.BigDecimal;
import java.util.UUID;

@Setter
@Getter
public class BaseProductDTO {
    @Id
    private UUID id;
    private String productType;
    private String producingCountry;
    private String brandName;
    private Boolean isOnlineOrdering;
    private Boolean isSoldByInstallments;
    private Boolean available;
    private String modelName;
    private String serialNumber;
    private String colorName;
    private BigDecimal price;
    private String size;

    public BaseProductDTO() {
    }

    public BaseProductDTO(UUID id, String productType, String producingCountry, String brandName, boolean isOnlineOrdering, boolean isSoldByInstallments, boolean isAvailable, String modelName, String serialNumber, String colorName, BigDecimal price, String size) {
        this.id = id;
        this.productType = productType;
        this.producingCountry = producingCountry;
        this.brandName = brandName;
        this.isOnlineOrdering = isOnlineOrdering;
        this.isSoldByInstallments = isSoldByInstallments;
        this.available = isAvailable;
        this.modelName = modelName;
        this.serialNumber = serialNumber;
        this.colorName = colorName;
        this.price = price;
        this.size = size;
    }
}