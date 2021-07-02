package com.example.isandstesttask.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@MappedSuperclass
@Setter
@Getter
@NoArgsConstructor
public class BaseProduct extends BaseEntity {
    private String productType;
    private String producingCountry;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn (name="brands_id")
    private Brand brandName;

    private boolean isOnlineOrdering;
    private boolean isSoldByInstallments;
    private boolean isAvailable;
    private String modelName;
    private String serialNumber;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn (name="colors_id")
    private Color colorName;

    private BigDecimal price;
    private String size;
    @Transient
    private List<? extends BaseProduct> modelList;
    public BaseProduct(String productType, String producingCountry, Brand brandName, boolean isOnlineOrdering, boolean isSoldByInstallments, boolean isAvailable, String modelName, String serialNumber, Color colorName, BigDecimal price, String size, List<? extends BaseProduct> modelList) {
        this.productType = productType;
        this.producingCountry = producingCountry;
        this.brandName = brandName;
        this.isOnlineOrdering = isOnlineOrdering;
        this.isSoldByInstallments = isSoldByInstallments;
        this.isAvailable = isAvailable;
        this.modelName = modelName;
        this.serialNumber = serialNumber;
        this.colorName = colorName;
        this.price = price;
        this.size = size;
        this.modelList = modelList;
    }

    public BaseProduct(UUID id, Timestamp createdDate, Timestamp lastModifiedDate, String productType, String producingCountry, Brand brandName, boolean isOnlineOrdering, boolean isSoldByInstallments, boolean isAvailable, String modelName, String serialNumber, Color colorName, BigDecimal price, String size, List<? extends BaseProduct> modelList) {
        super(id, createdDate, lastModifiedDate);
        this.productType = productType;
        this.producingCountry = producingCountry;
        this.brandName = brandName;
        this.isOnlineOrdering = isOnlineOrdering;
        this.isSoldByInstallments = isSoldByInstallments;
        this.isAvailable = isAvailable;
        this.modelName = modelName;
        this.serialNumber = serialNumber;
        this.colorName = colorName;
        this.price = price;
        this.size = size;
        this.modelList = modelList;
    }
}