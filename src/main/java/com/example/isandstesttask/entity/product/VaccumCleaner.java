package com.example.isandstesttask.entity.product;

import java.math.BigDecimal;

public interface VaccumCleaner {
    BigDecimal getDustContainerVolume();

    void setDustContainerVolume(BigDecimal volume);

    Integer getModesNumber();

    void setModesNumber(Integer number);
}