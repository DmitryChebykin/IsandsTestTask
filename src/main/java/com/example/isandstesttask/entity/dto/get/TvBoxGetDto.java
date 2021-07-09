package com.example.isandstesttask.entity.dto.get;

import com.example.isandstesttask.util.SortDirection;
import com.example.isandstesttask.util.VacuumCleanerSortedFields;
import java.math.BigDecimal;
import java.util.Optional;

public class TvBoxGetDto {
    private final Optional<BigDecimal> minPrice;
    private final Optional<BigDecimal> maxPrice;
    private final Optional<String> color;
    private final Optional<String> brand;
    private final Optional<String> category;
    private final Optional<String> country;
    private final Optional<String> serial;
    private final Optional<String> model;
    private final Optional<String> size;
    private final Optional<String> technology;
    private final Optional<Boolean> available;
    private final Optional<Boolean> isOnlineOrdering;
    private final Optional<Boolean> isSoldByInstallments;
    private final Optional<VacuumCleanerSortedFields> sortBy;
    private final Optional<SortDirection> sortType;

    public TvBoxGetDto(Optional<BigDecimal> minPrice, Optional<BigDecimal> maxPrice, Optional<String> color, Optional<String> brand, Optional<String> category, Optional<String> country, Optional<String> serial, Optional<String> model, Optional<String> size, Optional<String> technology, Optional<Boolean> available, Optional<Boolean> isOnlineOrdering, Optional<Boolean> isSoldByInstallments, Optional<VacuumCleanerSortedFields> sortBy, Optional<SortDirection> sortType) {
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.color = color;
        this.brand = brand;
        this.category = category;
        this.country = country;
        this.serial = serial;
        this.model = model;
        this.size = size;
        this.technology = technology;
        this.available = available;
        this.isOnlineOrdering = isOnlineOrdering;
        this.isSoldByInstallments = isSoldByInstallments;
        this.sortBy = sortBy;
        this.sortType = sortType;
    }

    public Optional<BigDecimal> getMinPrice() {
        return minPrice;
    }

    public Optional<BigDecimal> getMaxPrice() {
        return maxPrice;
    }

    public Optional<String> getColor() {
        return color;
    }

    public Optional<String> getBrand() {
        return brand;
    }

    public Optional<String> getCategory() {
        return category;
    }

    public Optional<String> getCountry() {
        return country;
    }

    public Optional<String> getSerial() {
        return serial;
    }

    public Optional<String> getModel() {
        return model;
    }

    public Optional<String> getSize() {
        return size;
    }

    public Optional<String> getTechnology() {
        return technology;
    }

    public Optional<Boolean> getAvailable() {
        return available;
    }

    public Optional<Boolean> getIsOnlineOrdering() {
        return isOnlineOrdering;
    }

    public Optional<Boolean> getIsSoldByInstallments() {
        return isSoldByInstallments;
    }

    public Optional<VacuumCleanerSortedFields> getSortBy() {
        return sortBy;
    }

    public Optional<SortDirection> getSortType() {
        return sortType;
    }
}