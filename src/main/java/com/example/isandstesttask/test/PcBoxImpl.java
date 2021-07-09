package com.example.isandstesttask.test;

import com.example.isandstesttask.entity.BaseProduct;
import com.example.isandstesttask.entity.BaseProductImpl;
import com.example.isandstesttask.entity.product.PcBox;
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
@Table(name = "pc_boxes", uniqueConstraints = {@UniqueConstraint(name = "serialNumber_pc", columnNames = {"serial_number"})},
        indexes = {@Index(columnList = "available"),
                @Index(columnList = "is_sold_by_installments"),
                @Index(columnList = "is_online_ordering"),
                @Index(columnList = "category"),
                @Index(columnList = "processorType"),
                @Index(columnList = "colors_id"),
                @Index(columnList = "brands_id"),
        })

@DynamicUpdate
@DynamicInsert
@SelectBeforeUpdate

@Setter
@Getter
@NoArgsConstructor

public class PcBoxImpl extends BaseProductImpl implements BaseProduct, PcBox {
    @Column(name = "product_type")
    private final String productType = "PcBox";
    private String category;
    private String processorType;

    public PcBoxImpl(Timestamp createdDate, Timestamp lastModifiedDate, String productType, String producingCountry, Brand brandName, Boolean isOnlineOrdering, Boolean isSoldByInstallments, Boolean available, String modelName, String serialNumber, Color colorName, BigDecimal price, String size, String category, String processorType) {
        super(createdDate, lastModifiedDate, productType, producingCountry, brandName, isOnlineOrdering, isSoldByInstallments, available, modelName, serialNumber, colorName, price, size);
        this.category = category;
        this.processorType = processorType;
    }

    @Override
    public String toString() {
        return "PcBox{" +
                "category='" + category + '\'' +
                ", processorType='" + processorType + '\'' +
                "} " + super.toString();
    }

    public static final class PcBoxImplBuilder {
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
        private String category;
        private String processorType;

        private PcBoxImplBuilder() {
        }

        public static PcBoxImplBuilder aPcBoxImpl() {
            return new PcBoxImplBuilder();
        }

        public PcBoxImplBuilder id(UUID id) {
            this.id = id;
            return this;
        }

        public PcBoxImplBuilder createdDate(Timestamp createdDate) {
            this.createdDate = createdDate;
            return this;
        }

        public PcBoxImplBuilder lastModifiedDate(Timestamp lastModifiedDate) {
            this.lastModifiedDate = lastModifiedDate;
            return this;
        }

        public PcBoxImplBuilder producingCountry(String producingCountry) {
            this.producingCountry = producingCountry;
            return this;
        }

        public PcBoxImplBuilder brandName(Brand brandName) {
            this.brandName = brandName;
            return this;
        }

        public PcBoxImplBuilder isOnlineOrdering(Boolean isOnlineOrdering) {
            this.isOnlineOrdering = isOnlineOrdering;
            return this;
        }

        public PcBoxImplBuilder isSoldByInstallments(Boolean isSoldByInstallments) {
            this.isSoldByInstallments = isSoldByInstallments;
            return this;
        }

        public PcBoxImplBuilder available(Boolean available) {
            this.available = available;
            return this;
        }

        public PcBoxImplBuilder modelName(String modelName) {
            this.modelName = modelName;
            return this;
        }

        public PcBoxImplBuilder serialNumber(String serialNumber) {
            this.serialNumber = serialNumber;
            return this;
        }

        public PcBoxImplBuilder colorName(Color colorName) {
            this.colorName = colorName;
            return this;
        }

        public PcBoxImplBuilder price(BigDecimal price) {
            this.price = price;
            return this;
        }

        public PcBoxImplBuilder size(String size) {
            this.size = size;
            return this;
        }

        public PcBoxImplBuilder productType(String productType) {
            this.productType = productType;
            return this;
        }

        public PcBoxImplBuilder category(String category) {
            this.category = category;
            return this;
        }

        public PcBoxImplBuilder processorType(String processorType) {
            this.processorType = processorType;
            return this;
        }

        public PcBoxImpl build() {
            PcBoxImpl pcBoxImpl = new PcBoxImpl();
            pcBoxImpl.setId(id);
            pcBoxImpl.setCreatedDate(createdDate);
            pcBoxImpl.setLastModifiedDate(lastModifiedDate);
            pcBoxImpl.setProducingCountry(producingCountry);
            pcBoxImpl.setBrandName(brandName);
            pcBoxImpl.setIsOnlineOrdering(isOnlineOrdering);
            pcBoxImpl.setIsSoldByInstallments(isSoldByInstallments);
            pcBoxImpl.setAvailable(available);
            pcBoxImpl.setModelName(modelName);
            pcBoxImpl.setSerialNumber(serialNumber);
            pcBoxImpl.setColorName(colorName);
            pcBoxImpl.setPrice(price);
            pcBoxImpl.setSize(size);
            pcBoxImpl.setProductType(productType);
            pcBoxImpl.setCategory(category);
            pcBoxImpl.setProcessorType(processorType);
            return pcBoxImpl;
        }
    }
}