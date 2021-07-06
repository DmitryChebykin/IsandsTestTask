package com.example.isandstesttask.entity;

import com.example.isandstesttask.entity.reference.Brand;
import com.example.isandstesttask.entity.reference.Color;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

@MappedSuperclass
@Setter
@Getter
@NoArgsConstructor
public class BaseProduct extends BaseEntity {
    private String productType;
    private String producingCountry;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "brands_id")
    private Brand brandName;

    private Boolean isOnlineOrdering;
    private Boolean isSoldByInstallments;
    private Boolean available;
    private String modelName;

    @Column(name = "serial_number")
    private String serialNumber;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "colors_id")
    private Color colorName;

    private BigDecimal price;
    private String size;

    public BaseProduct(Timestamp createdDate, Timestamp lastModifiedDate, String productType, String producingCountry, Brand brandName, Boolean isOnlineOrdering, Boolean isSoldByInstallments, Boolean available, String modelName, String serialNumber, Color colorName, BigDecimal price, String size) {
        super(createdDate, lastModifiedDate);
        this.productType = productType;
        this.producingCountry = producingCountry;
        this.brandName = brandName;
        this.isOnlineOrdering = isOnlineOrdering;
        this.isSoldByInstallments = isSoldByInstallments;
        this.available = available;
        this.modelName = modelName;
        this.serialNumber = serialNumber;
        this.colorName = colorName;
        this.price = price;
        this.size = size;
    }

    @Override
    public String toString() {
        return "BaseProduct{" +
                "id=" + id +
                ", productType='" + productType + '\'' +
                ", producingCountry='" + producingCountry + '\'' +
                ", brandName=" + brandName +
                ", isOnlineOrdering=" + isOnlineOrdering +
                ", isSoldByInstallments=" + isSoldByInstallments +
                ", available=" + available +
                ", modelName='" + modelName + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", colorName=" + colorName +
                ", price=" + price +
                ", size='" + size + '\'' +
                "} " + super.toString();
    }
}