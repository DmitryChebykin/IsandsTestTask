package com.example.isandstesttask.test;

import com.example.isandstesttask.entity.BaseProduct;
import com.example.isandstesttask.entity.BaseProductImpl;
import com.example.isandstesttask.entity.product.Refrigerator;
import com.example.isandstesttask.entity.reference.Brand;
import com.example.isandstesttask.entity.reference.Color;
import com.example.isandstesttask.entity.reference.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "refrigerator", uniqueConstraints = {@UniqueConstraint(name = "serialNumber_ref", columnNames = {"serial_number"})},
        indexes = {@Index(columnList = "available"),
                @Index(columnList = "is_sold_by_installments"),
                @Index(columnList = "is_online_ordering"),
                @Index(columnList = "category"),
                @Index(columnList = "technology"),
                @Index(columnList = "colors_id"),
                @Index(columnList = "brands_id"),
        })

@DynamicUpdate
@DynamicInsert
@SelectBeforeUpdate

@Setter
@Getter
@NoArgsConstructor

public class RefrigeratorImpl extends BaseProductImpl implements BaseProduct, Refrigerator, Product {
    @Column(name = "product_type")
    private final String productType = "refrigerator";
    private String category;
    private String technology;

    public RefrigeratorImpl(Timestamp createdDate, Timestamp lastModifiedDate, String productType, String producingCountry, Brand brandName, Boolean isOnlineOrdering, Boolean isSoldByInstallments, Boolean available, String modelName, String serialNumber, Color colorName, BigDecimal price, String size, String category, String technology) {
        super(createdDate, lastModifiedDate, productType, producingCountry, brandName, isOnlineOrdering, isSoldByInstallments, available, modelName, serialNumber, colorName, price, size);
        this.category = category;
        this.technology = technology;
    }

    @Override
    public String toString() {
        return "Refrigerator{" +
                "category='" + category + '\'' +
                ", technology='" + technology + '\'' +
                "} " + super.toString();
    }

    public static final class RefrigeratorBuilder {
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
        private String category;
        private String technology;

        private RefrigeratorBuilder() {
        }

        public static RefrigeratorBuilder aRefrigerator() {
            return new RefrigeratorBuilder();
        }

        public RefrigeratorBuilder createdDate(Timestamp createdDate) {
            this.createdDate = createdDate;
            return this;
        }

        public RefrigeratorBuilder lastModifiedDate(Timestamp lastModifiedDate) {
            this.lastModifiedDate = lastModifiedDate;
            return this;
        }

        public RefrigeratorBuilder productType(String productType) {
            this.productType = productType;
            return this;
        }

        public RefrigeratorBuilder producingCountry(String producingCountry) {
            this.producingCountry = producingCountry;
            return this;
        }

        public RefrigeratorBuilder brandName(Brand brandName) {
            this.brandName = brandName;
            return this;
        }

        public RefrigeratorBuilder isOnlineOrdering(Boolean isOnlineOrdering) {
            this.isOnlineOrdering = isOnlineOrdering;
            return this;
        }

        public RefrigeratorBuilder isSoldByInstallments(Boolean isSoldByInstallments) {
            this.isSoldByInstallments = isSoldByInstallments;
            return this;
        }

        public RefrigeratorBuilder available(Boolean available) {
            this.available = available;
            return this;
        }

        public RefrigeratorBuilder modelName(String modelName) {
            this.modelName = modelName;
            return this;
        }

        public RefrigeratorBuilder serialNumber(String serialNumber) {
            this.serialNumber = serialNumber;
            return this;
        }

        public RefrigeratorBuilder colorName(Color colorName) {
            this.colorName = colorName;
            return this;
        }

        public RefrigeratorBuilder price(BigDecimal price) {
            this.price = price;
            return this;
        }

        public RefrigeratorBuilder size(String size) {
            this.size = size;
            return this;
        }

        public RefrigeratorBuilder category(String category) {
            this.category = category;
            return this;
        }

        public RefrigeratorBuilder technology(String technology) {
            this.technology = technology;
            return this;
        }

        public RefrigeratorImpl build() {
            RefrigeratorImpl refrigerator = new RefrigeratorImpl();
            refrigerator.setCreatedDate(createdDate);
            refrigerator.setLastModifiedDate(lastModifiedDate);
            refrigerator.setProductType(productType);
            refrigerator.setProducingCountry(producingCountry);
            refrigerator.setBrandName(brandName);
            refrigerator.setIsOnlineOrdering(isOnlineOrdering);
            refrigerator.setIsSoldByInstallments(isSoldByInstallments);
            refrigerator.setAvailable(available);
            refrigerator.setModelName(modelName);
            refrigerator.setSerialNumber(serialNumber);
            refrigerator.setColorName(colorName);
            refrigerator.setPrice(price);
            refrigerator.setSize(size);
            refrigerator.setCategory(category);
            refrigerator.setTechnology(technology);
            return refrigerator;
        }
    }
}