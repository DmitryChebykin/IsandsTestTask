package com.example.isandstesttask.service.filter;

import com.example.isandstesttask.entity.reference.Brand;
import com.example.isandstesttask.entity.reference.Color;
import lombok.*;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaseSearchCriteria {
    private UUID id;
    private String producingCountry;
    private Brand brandName;
    private boolean isOnlineOrdering;
    private boolean isSoldByInstallments;
    private boolean isAvailable;
    private String modelName;
    private String serialNumber;
    private Color colorName;
    private BigDecimal maxPrice;
    private BigDecimal minPrice;
    private String size;
}