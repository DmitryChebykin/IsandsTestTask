package com.example.isandstesttask.entity.dto.create;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.lang.NonNullFields;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

@Setter
@Getter
public class BaseProductDTO {
    @NotNull
    private String productType;
    @NotNull
    private String producingCountry;
    @NotNull
    private String brandName;
    @NotNull
    private Boolean isOnlineOrdering;
    @NotNull
    private Boolean isSoldByInstallments;
    @NotNull
    private Boolean available;
    @NotNull
    private String modelName;
    @NotNull
    private String serialNumber;
    @NotNull
    private String colorName;
    @NotNull
    private BigDecimal price;
    @NotNull
    private String size;

    public BaseProductDTO() {
    }

    public BaseProductDTO(String productType, String producingCountry, String brandName, boolean isOnlineOrdering, boolean isSoldByInstallments, boolean isAvailable, String modelName, String serialNumber, String colorName, BigDecimal price, String size) {
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