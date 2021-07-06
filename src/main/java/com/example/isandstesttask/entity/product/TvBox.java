package com.example.isandstesttask.entity.product;

import com.example.isandstesttask.entity.BaseProduct;
import com.example.isandstesttask.entity.reference.Brand;
import com.example.isandstesttask.entity.reference.Color;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(name = "serial_number", columnNames = {"serial_number"})})

@DynamicUpdate
@DynamicInsert
@SelectBeforeUpdate

@Setter
@Getter
@NoArgsConstructor
public class TvBox extends BaseProduct {
    public static final String PRODUCT_TYPE = "television";
    private String category;
    private String technology;

    public TvBox(Timestamp createdDate, Timestamp lastModifiedDate, String productType, String producingCountry, Brand brandName, Boolean isOnlineOrdering, Boolean isSoldByInstallments, Boolean available, String modelName, String serialNumber, Color colorName, BigDecimal price, String size, String category, String technology) {
        super(createdDate, lastModifiedDate, productType, producingCountry, brandName, isOnlineOrdering, isSoldByInstallments, available, modelName, serialNumber, colorName, price, size);
        this.category = category;
        this.technology = technology;
    }

    @Override
    public String toString() {
        return "TvBox{" +
                "category='" + category + '\'' +
                ", technology='" + technology + '\'' +
                "} " + super.toString();
    }

    public static final class TvBoxBuilder {
        public static String PRODUCT_TYPE = "television";
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

        private TvBoxBuilder() {
        }

        public static TvBoxBuilder aTvBox() {
            return new TvBoxBuilder();
        }


        public TvBoxBuilder createdDate(Timestamp createdDate) {
            this.createdDate = createdDate;
            return this;
        }

        public TvBoxBuilder lastModifiedDate(Timestamp lastModifiedDate) {
            this.lastModifiedDate = lastModifiedDate;
            return this;
        }

        public TvBoxBuilder productType(String productType) {
            this.productType = productType;
            return this;
        }

        public TvBoxBuilder producingCountry(String producingCountry) {
            this.producingCountry = producingCountry;
            return this;
        }

        public TvBoxBuilder brandName(Brand brandName) {
            this.brandName = brandName;
            return this;
        }

        public TvBoxBuilder isOnlineOrdering(Boolean isOnlineOrdering) {
            this.isOnlineOrdering = isOnlineOrdering;
            return this;
        }

        public TvBoxBuilder isSoldByInstallments(Boolean isSoldByInstallments) {
            this.isSoldByInstallments = isSoldByInstallments;
            return this;
        }

        public TvBoxBuilder available(Boolean available) {
            this.available = available;
            return this;
        }

        public TvBoxBuilder modelName(String modelName) {
            this.modelName = modelName;
            return this;
        }

        public TvBoxBuilder serialNumber(String serialNumber) {
            this.serialNumber = serialNumber;
            return this;
        }

        public TvBoxBuilder colorName(Color colorName) {
            this.colorName = colorName;
            return this;
        }

        public TvBoxBuilder price(BigDecimal price) {
            this.price = price;
            return this;
        }

        public TvBoxBuilder size(String size) {
            this.size = size;
            return this;
        }


        public TvBoxBuilder category(String category) {
            this.category = category;
            return this;
        }

        public TvBoxBuilder technology(String technology) {
            this.technology = technology;
            return this;
        }

        public TvBoxBuilder but() {
            return aTvBox().createdDate(createdDate).lastModifiedDate(lastModifiedDate).productType(productType).producingCountry(producingCountry).brandName(brandName).isOnlineOrdering(isOnlineOrdering).isSoldByInstallments(isSoldByInstallments).available(available).modelName(modelName).serialNumber(serialNumber).colorName(colorName).price(price).size(size).category(category).technology(technology);
        }

        public TvBox build() {
            TvBox tvBox = new TvBox();
            tvBox.setCreatedDate(createdDate);
            tvBox.setLastModifiedDate(lastModifiedDate);
            tvBox.setProductType(productType);
            tvBox.setProducingCountry(producingCountry);
            tvBox.setBrandName(brandName);
            tvBox.setIsOnlineOrdering(isOnlineOrdering);
            tvBox.setIsSoldByInstallments(isSoldByInstallments);
            tvBox.setAvailable(available);
            tvBox.setModelName(modelName);
            tvBox.setSerialNumber(serialNumber);
            tvBox.setColorName(colorName);
            tvBox.setPrice(price);
            tvBox.setSize(size);
            tvBox.setCategory(category);
            tvBox.setTechnology(technology);
            return tvBox;
        }
    }
}