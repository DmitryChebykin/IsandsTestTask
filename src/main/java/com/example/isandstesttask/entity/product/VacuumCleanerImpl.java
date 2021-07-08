package com.example.isandstesttask.entity.product;

import com.example.isandstesttask.entity.BaseProduct;
import com.example.isandstesttask.entity.BaseProductImpl;
import com.example.isandstesttask.entity.product.interfaces.VaccumCleaner;
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
@Table(name = "vacuum_cleaner", uniqueConstraints = {@UniqueConstraint(name = "serialNumberOfVacuumCleaner", columnNames = {"serial_number"})},
        indexes = {@Index(columnList = "available"),
                @Index(columnList = "is_sold_by_installments"),
                @Index(columnList = "is_online_ordering"),
                @Index(columnList = "colors_id"),
                @Index(columnList = "brands_id"),
                @Index(columnList = "dust_container_volume"),
                @Index(columnList = "modes_number"),
        })

@Setter
@Getter
@NoArgsConstructor

@DynamicUpdate
@DynamicInsert
@SelectBeforeUpdate

public class VacuumCleanerImpl extends BaseProductImpl implements BaseProduct, VaccumCleaner {
    @Column(name = "product_type")
    private final String productType = "vacuum_cleaner";
    @Column(name = "dust_container_volume")
    private BigDecimal DustContainerVolume;
    @Column(name = "modes_number")
    private Integer ModesNumber;

    @Override
    public int hashCode() {
        int result = getDustContainerVolume().hashCode();
        result = 31 * result + getModesNumber().hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof VacuumCleanerImpl)) {
            return false;
        }

        VacuumCleanerImpl that = (VacuumCleanerImpl) o;

        if (!getDustContainerVolume().equals(that.getDustContainerVolume())) {
            return false;
        }
        return getModesNumber().equals(that.getModesNumber());
    }

    public static final class VacuumCleanerImplBuilder {
        UUID id;
        private Timestamp createdDate;
        private Timestamp lastModifiedDate;
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
        private BigDecimal DustContainerVolume;
        private Integer ModesNumber;

        private VacuumCleanerImplBuilder() {
        }

        public static VacuumCleanerImplBuilder aVacuumCleanerImpl() {
            return new VacuumCleanerImplBuilder();
        }

        public VacuumCleanerImplBuilder id(UUID id) {
            this.id = id;
            return this;
        }

        public VacuumCleanerImplBuilder createdDate(Timestamp createdDate) {
            this.createdDate = createdDate;
            return this;
        }

        public VacuumCleanerImplBuilder lastModifiedDate(Timestamp lastModifiedDate) {
            this.lastModifiedDate = lastModifiedDate;
            return this;
        }

        public VacuumCleanerImplBuilder producingCountry(String producingCountry) {
            this.producingCountry = producingCountry;
            return this;
        }

        public VacuumCleanerImplBuilder brandName(Brand brandName) {
            this.brandName = brandName;
            return this;
        }

        public VacuumCleanerImplBuilder isOnlineOrdering(Boolean isOnlineOrdering) {
            this.isOnlineOrdering = isOnlineOrdering;
            return this;
        }

        public VacuumCleanerImplBuilder isSoldByInstallments(Boolean isSoldByInstallments) {
            this.isSoldByInstallments = isSoldByInstallments;
            return this;
        }

        public VacuumCleanerImplBuilder available(Boolean available) {
            this.available = available;
            return this;
        }

        public VacuumCleanerImplBuilder modelName(String modelName) {
            this.modelName = modelName;
            return this;
        }

        public VacuumCleanerImplBuilder serialNumber(String serialNumber) {
            this.serialNumber = serialNumber;
            return this;
        }

        public VacuumCleanerImplBuilder colorName(Color colorName) {
            this.colorName = colorName;
            return this;
        }

        public VacuumCleanerImplBuilder price(BigDecimal price) {
            this.price = price;
            return this;
        }

        public VacuumCleanerImplBuilder size(String size) {
            this.size = size;
            return this;
        }

        public VacuumCleanerImplBuilder DustContainerVolume(BigDecimal DustContainerVolume) {
            this.DustContainerVolume = DustContainerVolume;
            return this;
        }

        public VacuumCleanerImplBuilder ModesNumber(Integer ModesNumber) {
            this.ModesNumber = ModesNumber;
            return this;
        }

        public VacuumCleanerImpl build() {
            VacuumCleanerImpl vacuumCleanerImpl = new VacuumCleanerImpl();
            vacuumCleanerImpl.setId(id);
            vacuumCleanerImpl.setCreatedDate(createdDate);
            vacuumCleanerImpl.setLastModifiedDate(lastModifiedDate);
            vacuumCleanerImpl.setProducingCountry(producingCountry);
            vacuumCleanerImpl.setBrandName(brandName);
            vacuumCleanerImpl.setIsOnlineOrdering(isOnlineOrdering);
            vacuumCleanerImpl.setIsSoldByInstallments(isSoldByInstallments);
            vacuumCleanerImpl.setAvailable(available);
            vacuumCleanerImpl.setModelName(modelName);
            vacuumCleanerImpl.setSerialNumber(serialNumber);
            vacuumCleanerImpl.setColorName(colorName);
            vacuumCleanerImpl.setPrice(price);
            vacuumCleanerImpl.setSize(size);
            vacuumCleanerImpl.setDustContainerVolume(DustContainerVolume);
            vacuumCleanerImpl.setModesNumber(ModesNumber);
            return vacuumCleanerImpl;
        }
    }
}