package com.example.isandstesttask.entity.product;

import com.example.isandstesttask.entity.BaseProduct;
import com.example.isandstesttask.entity.BaseProductImpl;
import com.example.isandstesttask.entity.reference.Brand;
import com.example.isandstesttask.entity.reference.Color;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "refrigerators", uniqueConstraints = {@UniqueConstraint(name = "serialNumber_ref", columnNames = {"serial_number"})},
        indexes = {@Index(columnList = "available"),
                @Index(columnList = "is_sold_by_installments"),
                @Index(columnList = "is_online_ordering"),
                @Index(columnList = "compressor_type"),
                @Index(columnList = "doors_number"),
                @Index(columnList = "colors_id"),
                @Index(columnList = "brands_id"),
        })

@DynamicUpdate
@DynamicInsert
@SelectBeforeUpdate

@Setter
@Getter
@NoArgsConstructor

public class RefrigeratorImpl extends BaseProductImpl implements BaseProduct, Refrigerator {
    @Column(name = "product_type")
    private final String productType = "refrigerator";
    @Column(name = "compressor_type")
    private String compressorType;
    @Column(name = "doors_number")
    private Integer doorsNumber;

    public RefrigeratorImpl(Timestamp createdDate, Timestamp lastModifiedDate, String productType, String producingCountry, Brand brandName, Boolean isOnlineOrdering, Boolean isSoldByInstallments, Boolean available, String modelName, String serialNumber, Color colorName, BigDecimal price, String size, String compressorType, Integer doorsNumber) {
        super(createdDate, lastModifiedDate, productType, producingCountry, brandName, isOnlineOrdering, isSoldByInstallments, available, modelName, serialNumber, colorName, price, size);
        this.compressorType = compressorType;
        this.doorsNumber = doorsNumber;
    }


    public static final class RefrigeratorImplBuilder {
        UUID id;
        private Timestamp createdDate;
        private Timestamp lastModifiedDate;
        private String productType;
        private String producingCountry;
        private Brand brandName;
        private Boolean isOnlineOrdering;
        private Boolean isSoldByInstallments;
        private Boolean available;
        private String modelName;
        private String serialNumber;

        private Color colorName;
        private BigDecimal price;
        private String size;
        private String compressorType;
        private Integer doorsNumber;

        private RefrigeratorImplBuilder() {
        }

        public static RefrigeratorImplBuilder aRefrigeratorImpl() {
            return new RefrigeratorImplBuilder();
        }

        public RefrigeratorImplBuilder id(UUID id) {
            this.id = id;
            return this;
        }

        public RefrigeratorImplBuilder createdDate(Timestamp createdDate) {
            this.createdDate = createdDate;
            return this;
        }

        public RefrigeratorImplBuilder lastModifiedDate(Timestamp lastModifiedDate) {
            this.lastModifiedDate = lastModifiedDate;
            return this;
        }

        public RefrigeratorImplBuilder producingCountry(String producingCountry) {
            this.producingCountry = producingCountry;
            return this;
        }

        public RefrigeratorImplBuilder brandName(Brand brandName) {
            this.brandName = brandName;
            return this;
        }

        public RefrigeratorImplBuilder isOnlineOrdering(Boolean isOnlineOrdering) {
            this.isOnlineOrdering = isOnlineOrdering;
            return this;
        }

        public RefrigeratorImplBuilder isSoldByInstallments(Boolean isSoldByInstallments) {
            this.isSoldByInstallments = isSoldByInstallments;
            return this;
        }

        public RefrigeratorImplBuilder available(Boolean available) {
            this.available = available;
            return this;
        }

        public RefrigeratorImplBuilder modelName(String modelName) {
            this.modelName = modelName;
            return this;
        }

        public RefrigeratorImplBuilder serialNumber(String serialNumber) {
            this.serialNumber = serialNumber;
            return this;
        }

        public RefrigeratorImplBuilder colorName(Color colorName) {
            this.colorName = colorName;
            return this;
        }

        public RefrigeratorImplBuilder price(BigDecimal price) {
            this.price = price;
            return this;
        }

        public RefrigeratorImplBuilder size(String size) {
            this.size = size;
            return this;
        }

        public RefrigeratorImplBuilder productType(String productType) {
            this.productType = productType;
            return this;
        }

        public RefrigeratorImplBuilder compressorType(String compressorType) {
            this.compressorType = compressorType;
            return this;
        }

        public RefrigeratorImplBuilder doorsNumber(Integer doorsNumber) {
            this.doorsNumber = doorsNumber;
            return this;
        }

        public RefrigeratorImpl build() {
            RefrigeratorImpl refrigeratorImpl = new RefrigeratorImpl();
            refrigeratorImpl.setId(id);
            refrigeratorImpl.setCreatedDate(createdDate);
            refrigeratorImpl.setLastModifiedDate(lastModifiedDate);
            refrigeratorImpl.setProducingCountry(producingCountry);
            refrigeratorImpl.setBrandName(brandName);
            refrigeratorImpl.setIsOnlineOrdering(isOnlineOrdering);
            refrigeratorImpl.setIsSoldByInstallments(isSoldByInstallments);
            refrigeratorImpl.setAvailable(available);
            refrigeratorImpl.setModelName(modelName);
            refrigeratorImpl.setSerialNumber(serialNumber);
            refrigeratorImpl.setColorName(colorName);
            refrigeratorImpl.setPrice(price);
            refrigeratorImpl.setSize(size);
            refrigeratorImpl.setProductType(productType);
            refrigeratorImpl.setCompressorType(compressorType);
            refrigeratorImpl.setDoorsNumber(doorsNumber);
            return refrigeratorImpl;
        }
    }
}