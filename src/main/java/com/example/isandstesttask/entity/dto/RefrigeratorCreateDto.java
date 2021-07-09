package com.example.isandstesttask.entity.dto;

public interface RefrigeratorCreateDto extends BaseProductResponseDto {
    String getCompressorType();

    void setCompressorType(String compressorType);

    Integer getDoorsNumber();

    void setDoorsNumber(Integer doorsNumber);

    interface PhoneCreateDto extends BaseProductResponseDto {

        Integer getMemorySize();

        void setMemorySize(Integer memorySize);

        Integer getCamerasNumber();

        void setCamerasNumber(Integer camerasNumber);
    }

    interface PhoneResponseDto extends IdDto, BaseProductResponseDto, PhoneCreateDto {
        void setProductType();

        String getProductType();
    }
}