package com.example.isandstesttask.controller;

import com.example.isandstesttask.entity.dto.get.PcBoxGetDto;
import com.example.isandstesttask.entity.reference.Brand;
import com.example.isandstesttask.entity.reference.Color;
import com.example.isandstesttask.filter.pc.PcBoxSearchCriteria;
import com.example.isandstesttask.service.BrandService;
import com.example.isandstesttask.service.ColorService;
import com.example.isandstesttask.service.PcBoxService;
import com.example.isandstesttask.service.search.PcBoxSearchService;
import com.example.isandstesttask.entity.product.PcBox;
import com.example.isandstesttask.entity.dto.create.PcBoxCreatingDtoImpl;
import com.example.isandstesttask.entity.dto.response.PcBoxResponseDtoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product/pcbox")
public class PcBoxController {
    private final com.example.isandstesttask.service.PcBoxService PcBoxService;
    private final BrandService brandService;
    private final com.example.isandstesttask.service.search.PcBoxSearchService PcBoxSearchService;
    private final ColorService colorService;
    private PcBoxSearchCriteria pcBoxSearchCriteria;

    @Autowired
    public PcBoxController(PcBoxService PcBoxService, BrandService brandService, PcBoxSearchService PcBoxSearchService, ColorService colorService, PcBoxSearchCriteria pcBoxSearchCriteria) {
        this.PcBoxService = PcBoxService;
        this.brandService = brandService;
        this.PcBoxSearchService = PcBoxSearchService;
        this.colorService = colorService;
        this.pcBoxSearchCriteria = pcBoxSearchCriteria;
    }

    @PostMapping(path = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<PcBox> addPcBox(@RequestBody PcBoxCreatingDtoImpl PcBoxCreatingDtoImpl) {
        String id = PcBoxService.createPcBox(PcBoxCreatingDtoImpl);
        PcBox PcBox = PcBoxService.getProductById(id);
        return new ResponseEntity<>(PcBox, HttpStatus.CREATED);
    }

    @GetMapping(path = "/search/sorted", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    ResponseEntity<List<PcBoxResponseDtoImpl>> getFilteredPcBoxDto(PcBoxGetDto pcBoxGetDto) {

        setCriteria(pcBoxGetDto.getMinPrice(), pcBoxGetDto.getMaxPrice(), pcBoxGetDto.getColor(), pcBoxGetDto.getBrand(), pcBoxGetDto.getCategory(), pcBoxGetDto.getCountry(), pcBoxGetDto.getSerial(), pcBoxGetDto.getModel(), pcBoxGetDto.getSize(), pcBoxGetDto.getProcessorType(), pcBoxGetDto.getAvailable(), pcBoxGetDto.getIsOnlineOrdering(), pcBoxGetDto.getIsSoldByInstallments());

        List<PcBoxResponseDtoImpl> pcBoxes = PcBoxSearchService.getSortedListByNameAscAndPriceDescOfResponseDto(pcBoxSearchCriteria, pcBoxGetDto.getSortBy(), pcBoxGetDto.getSortType());

        return new ResponseEntity<>(pcBoxes, HttpStatus.OK);
    }

    private void setCriteria(Optional<BigDecimal> minPrice,
                             Optional<BigDecimal> maxPrice,
                             Optional<String> color,
                             Optional<String> brand,
                             Optional<String> category,
                             Optional<String> country,
                             Optional<String> serial,
                             Optional<String> model,
                             Optional<String> size,
                             Optional<String> processorType,
                             Optional<Boolean> available,
                             Optional<Boolean> isOnlineOrdering,
                             Optional<Boolean> isSoldByInstallments) {
        Optional<Brand> optionalBrand = Optional.ofNullable(brandService.getBrandByName(brand.orElse(null)));

        Optional<Color> optionalColor = Optional.ofNullable(colorService.getColorByName(color.orElse(null)));

        pcBoxSearchCriteria = PcBoxSearchCriteria.PcBoxSearchCriteriaBuilder.aPcBoxSearchCriteria().category(category)
                .brandName(optionalBrand)
                .colorName(optionalColor)
                .minPrice(minPrice)
                .maxPrice(maxPrice)
                .producingCountry(country)
                .serialNumber(serial)
                .modelName(model)
                .size(size)
                .processorType(processorType)
                .isAvailable(available)
                .isOnlineOrdering(isOnlineOrdering)
                .isSoldByInstallments(isSoldByInstallments)
                .build();
    }
}