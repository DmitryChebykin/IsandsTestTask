package com.example.isandstesttask.entity.product;

import com.example.isandstesttask.entity.BaseProduct;
import com.example.isandstesttask.entity.BaseProductImpl;
import com.example.isandstesttask.entity.product.Phone;
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
@Table(name = "phones", uniqueConstraints = {@UniqueConstraint(name = "serialNumber_phone", columnNames = {"serial_number"})},
        indexes = {@Index(columnList = "available"),
                @Index(columnList = "is_sold_by_installments"),
                @Index(columnList = "is_online_ordering"),
                @Index(columnList = "memory_size"),
                @Index(columnList = "cameras_number"),
                @Index(columnList = "colors_id"),
                @Index(columnList = "brands_id"),
        })

@DynamicUpdate
@DynamicInsert
@SelectBeforeUpdate

@Setter
@Getter
@NoArgsConstructor

public class PhoneImpl extends BaseProductImpl implements BaseProduct, Phone {
    @Column(name = "product_type")
    private final String productType = "Phone";
    @Column(name = "memory_size")
    private Integer memorySize;
    @Column(name = "cameras_number")
    private Integer camerasNumber;

    public PhoneImpl(Timestamp createdDate, Timestamp lastModifiedDate, String productType, String producingCountry, Brand brandName, Boolean isOnlineOrdering, Boolean isSoldByInstallments, Boolean available, String modelName, String serialNumber, Color colorName, BigDecimal price, String size, Integer memorySize, Integer camerasNumber) {
        super(createdDate, lastModifiedDate, productType, producingCountry, brandName, isOnlineOrdering, isSoldByInstallments, available, modelName, serialNumber, colorName, price, size);
        this.memorySize = memorySize;
        this.camerasNumber = camerasNumber;
    }

    public static final class PhoneImplBuilder {
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
        private Integer memorySize;
        private Integer camerasNumber;

        private PhoneImplBuilder() {
        }

        public static PhoneImplBuilder aPhoneImpl() {
            return new PhoneImplBuilder();
        }

        public PhoneImplBuilder id(UUID id) {
            this.id = id;
            return this;
        }

        public PhoneImplBuilder createdDate(Timestamp createdDate) {
            this.createdDate = createdDate;
            return this;
        }

        public PhoneImplBuilder lastModifiedDate(Timestamp lastModifiedDate) {
            this.lastModifiedDate = lastModifiedDate;
            return this;
        }

        public PhoneImplBuilder producingCountry(String producingCountry) {
            this.producingCountry = producingCountry;
            return this;
        }

        public PhoneImplBuilder brandName(Brand brandName) {
            this.brandName = brandName;
            return this;
        }

        public PhoneImplBuilder isOnlineOrdering(Boolean isOnlineOrdering) {
            this.isOnlineOrdering = isOnlineOrdering;
            return this;
        }

        public PhoneImplBuilder isSoldByInstallments(Boolean isSoldByInstallments) {
            this.isSoldByInstallments = isSoldByInstallments;
            return this;
        }

        public PhoneImplBuilder available(Boolean available) {
            this.available = available;
            return this;
        }

        public PhoneImplBuilder modelName(String modelName) {
            this.modelName = modelName;
            return this;
        }

        public PhoneImplBuilder serialNumber(String serialNumber) {
            this.serialNumber = serialNumber;
            return this;
        }

        public PhoneImplBuilder colorName(Color colorName) {
            this.colorName = colorName;
            return this;
        }

        public PhoneImplBuilder price(BigDecimal price) {
            this.price = price;
            return this;
        }

        public PhoneImplBuilder size(String size) {
            this.size = size;
            return this;
        }

        public PhoneImplBuilder productType(String productType) {
            this.productType = productType;
            return this;
        }

        public PhoneImplBuilder memorySize(Integer memorySize) {
            this.memorySize = memorySize;
            return this;
        }

        public PhoneImplBuilder camerasNumber(Integer camerasNumber) {
            this.camerasNumber = camerasNumber;
            return this;
        }

        public PhoneImpl build() {
            PhoneImpl phoneImpl = new PhoneImpl();
            phoneImpl.setId(id);
            phoneImpl.setCreatedDate(createdDate);
            phoneImpl.setLastModifiedDate(lastModifiedDate);
            phoneImpl.setProducingCountry(producingCountry);
            phoneImpl.setBrandName(brandName);
            phoneImpl.setIsOnlineOrdering(isOnlineOrdering);
            phoneImpl.setIsSoldByInstallments(isSoldByInstallments);
            phoneImpl.setAvailable(available);
            phoneImpl.setModelName(modelName);
            phoneImpl.setSerialNumber(serialNumber);
            phoneImpl.setColorName(colorName);
            phoneImpl.setPrice(price);
            phoneImpl.setSize(size);
            phoneImpl.setProductType(productType);
            phoneImpl.setMemorySize(memorySize);
            phoneImpl.setCamerasNumber(camerasNumber);
            return phoneImpl;
        }
    }
}