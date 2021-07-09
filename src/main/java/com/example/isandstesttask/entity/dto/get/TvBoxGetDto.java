package com.example.isandstesttask.entity.dto.get;

import com.example.isandstesttask.util.SortDirection;
import com.example.isandstesttask.util.VacuumCleanerSortedFields;
import org.springframework.web.bind.annotation.RequestParam;
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

    public TvBoxGetDto(@RequestParam(required = false) Optional<BigDecimal> minPrice, @RequestParam(required = false) Optional<BigDecimal> maxPrice, @RequestParam(required = false) Optional<String> color, @RequestParam(required = false) Optional<String> brand, @RequestParam(required = false) Optional<String> category, @RequestParam(required = false) Optional<String> country, @RequestParam(required = false) Optional<String> serial, @RequestParam(required = false) Optional<String> model, @RequestParam(required = false) Optional<String> size, @RequestParam(required = false) Optional<String> technology, @RequestParam(required = false) Optional<Boolean> available, @RequestParam(required = false) Optional<Boolean> isOnlineOrdering, @RequestParam(required = false) Optional<Boolean> isSoldByInstallments, @RequestParam(required = false) Optional<VacuumCleanerSortedFields> sortBy, @RequestParam(required = false) Optional<SortDirection> sortType) {
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