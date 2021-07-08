package com.example.isandstesttask.entity.dto.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString(callSuper = true)
@Setter
@Getter

public class VacuumCleanerResponseDtoImpl extends BaseProductResponseDtoImpl {
    private String DustContainerVolume;
    private String ModesNumber;
}