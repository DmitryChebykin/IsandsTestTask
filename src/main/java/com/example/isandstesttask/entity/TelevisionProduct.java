package com.example.isandstesttask.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(name = "modelName", columnNames = {"modelName"}),
        @UniqueConstraint(name = "serialNumber", columnNames = {"serialNumber"})})

@Setter
@Getter
@NoArgsConstructor
public class TelevisionProduct extends BaseProduct {
    private String category;
    private String technology;

    public TelevisionProduct(UUID id, Timestamp createdDate, Timestamp lastModifiedDate, String productType, String producingCountry, Brand brandName, boolean isOnlineOrdering, boolean isSoldByInstallments, boolean isAvailable, String modelName, String serialNumber, Color colorName, BigDecimal price, String size, List<TelevisionProduct> modelList, String category, String technology) {
        super(id, createdDate, lastModifiedDate, productType, producingCountry, brandName, isOnlineOrdering, isSoldByInstallments, isAvailable, modelName, serialNumber, colorName, price, size, modelList);
        this.category = category;
        this.technology = technology;
    }
}