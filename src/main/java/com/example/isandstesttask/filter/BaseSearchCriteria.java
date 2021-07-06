package com.example.isandstesttask.filter;

import com.example.isandstesttask.entity.reference.Brand;
import com.example.isandstesttask.entity.reference.Color;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaseSearchCriteria {
    private Optional<UUID> id;
    private Optional<String> producingCountry;
    private Optional<Brand> brandName;
    private Optional<Boolean> isOnlineOrdering;
    private Optional<Boolean> isSoldByInstallments;
    private Optional<Boolean> isAvailable;
    private Optional<String> modelName;
    private Optional<String> serialNumber;
    private Optional<Color> colorName;
    private Optional<BigDecimal> maxPrice;
    private Optional<BigDecimal> minPrice;
    private Optional<String> size;
}