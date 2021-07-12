package com.example.isandstesttask.entity.dto.update;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

@Setter
@Getter
public class TvBoxUpdateDto {
    @NotNull
    private final UUID id;
    private final Optional<BigDecimal> price;
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

    public TvBoxUpdateDto(UUID id, Optional<BigDecimal> price, Optional<String> color, Optional<String> brand, Optional<String> category, Optional<String> country, Optional<String> serial, Optional<String> model, Optional<String> size, Optional<String> technology, Optional<Boolean> available, Optional<Boolean> isOnlineOrdering, Optional<Boolean> isSoldByInstallments) {
        this.id = id;
        this.price = price;
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
    }
}