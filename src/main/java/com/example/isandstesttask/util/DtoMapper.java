package com.example.isandstesttask.util;

import com.example.isandstesttask.entity.BaseProduct;
import com.example.isandstesttask.entity.BaseProductImpl;
import com.example.isandstesttask.entity.dto.BaseProductResponseDto;
import com.example.isandstesttask.entity.dto.response.PhoneResponseDtoImpl;
import com.example.isandstesttask.entity.dto.response.RefrigeratorResponseDtoImpl;
import com.example.isandstesttask.entity.dto.response.TvBoxResponseDtoImpl;
import com.example.isandstesttask.entity.dto.response.VacuumCleanerResponseDtoImpl;
import com.example.isandstesttask.entity.product.PhoneImpl;
import com.example.isandstesttask.entity.product.RefrigeratorImpl;
import com.example.isandstesttask.entity.product.TvBoxImpl;
import com.example.isandstesttask.entity.product.VacuumCleanerImpl;
import com.example.isandstesttask.test.PcBoxImpl;
import com.example.isandstesttask.entity.dto.response.PcBoxResponseDtoImpl;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Getter
@Setter
@Service
public class DtoMapper<E extends BaseProductImpl> {
    private ModelMapper modelMapper;

    @Autowired
    public DtoMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.modelMapper.addMappings(new PropertyMap<E, BaseProductResponseDto>() {
            protected void configure() {
                map().setBrandName(source.getBrandName().getBrandName());
            }
        });
        this.modelMapper.addMappings(new PropertyMap<BaseProduct, BaseProductResponseDto>() {
            protected void configure() {
                map().setColorName(source.getColorName().getColorName());
            }
        });
    }

    public TvBoxResponseDtoImpl TvAsDTO(TvBoxImpl tvBox) {
        TvBoxResponseDtoImpl tvBoxResponseDto = new TvBoxResponseDtoImpl();

        modelMapper.map(tvBox, tvBoxResponseDto);

        return tvBoxResponseDto;
    }

    public VacuumCleanerResponseDtoImpl VacuumAsDTO(VacuumCleanerImpl vacuumCleaner) {
        VacuumCleanerResponseDtoImpl vacuumCleanerResponseDto = new VacuumCleanerResponseDtoImpl();

        modelMapper.map(vacuumCleaner, vacuumCleanerResponseDto);

        return vacuumCleanerResponseDto;
    }

    public RefrigeratorResponseDtoImpl RefAsDTO(RefrigeratorImpl ref) {
        RefrigeratorResponseDtoImpl refrigeratorResponseDto = new RefrigeratorResponseDtoImpl();

        modelMapper.map(ref, refrigeratorResponseDto);

        return refrigeratorResponseDto;
    }

    public PhoneResponseDtoImpl PhoneAsDTO(PhoneImpl phone) {
        PhoneResponseDtoImpl phoneResponseDtoImpl = new PhoneResponseDtoImpl();

        modelMapper.map(phone, phoneResponseDtoImpl);

        return phoneResponseDtoImpl;
    }

    public PcBoxResponseDtoImpl PcBoxAsDTO(PcBoxImpl pcBox) {
        PcBoxResponseDtoImpl pcBoxResponseDto = new PcBoxResponseDtoImpl();

        modelMapper.map(pcBox, pcBoxResponseDto);

        return pcBoxResponseDto;
    }
}