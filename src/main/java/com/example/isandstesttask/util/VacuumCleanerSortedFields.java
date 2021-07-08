package com.example.isandstesttask.util;

public enum VacuumCleanerSortedFields {

    MODEL_NAME("modelName"),

    COLOR_NAME("colorName"),

    BRAND_NAME("brandName"),

    SERIAL_NUMBER("serialNumber"),

    SIZE("size"),

    PRICE("price"),
    PRODUCING_COUNTRY("producingCountry"),

    IS_AVAILABLE("available"),

    IS_SOLD_BY_INSTALLMENTS("isSoldByInstallments"),

    IS_ONLINE_ORDERING("isOnlineOrdering"),

    MODES_NUMBER("ModesNumber"),

    DUST_CONTAINER_VOLUME("DustContainerVolume");

    public String getS() {
        return s;
    }

    VacuumCleanerSortedFields(String s) {
        this.s = s;
    }

    private final String s;


}