package com.example.isandstesttask.controller;

import com.example.isandstesttask.entity.product.Phone;
import com.example.isandstesttask.entity.reference.Brand;
import com.example.isandstesttask.entity.reference.Color;
import com.example.isandstesttask.service.BrandService;
import com.example.isandstesttask.service.ColorService;
import com.example.isandstesttask.service.PhoneService;
import com.example.isandstesttask.filter.phone.PhoneSearchCriteria;
import com.example.isandstesttask.service.search.PhoneSearchService;
import com.example.isandstesttask.entity.dto.create.PhoneCreatingDtoImpl;
import com.example.isandstesttask.entity.dto.response.PhoneResponseDtoImpl;
import com.example.isandstesttask.util.SortDirection;
import com.example.isandstesttask.util.VacuumCleanerSortedFields;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product/Phone")
public class PhoneController {
    private final com.example.isandstesttask.service.PhoneService PhoneService;
    private final BrandService brandService;
    private final com.example.isandstesttask.service.search.PhoneSearchService PhoneSearchService;
    private final ColorService colorService;
    private PhoneSearchCriteria phoneSearchCriteria;

    @Autowired
    public PhoneController(PhoneService PhoneService, BrandService brandService, PhoneSearchService PhoneSearchService, ColorService colorService, PhoneSearchCriteria phoneSearchCriteria) {
        this.PhoneService = PhoneService;
        this.brandService = brandService;
        this.PhoneSearchService = PhoneSearchService;
        this.colorService = colorService;
        this.phoneSearchCriteria = phoneSearchCriteria;
    }

    @PostMapping(path = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Phone> addPhone(@RequestBody PhoneCreatingDtoImpl PhoneCreatingDtoImpl) {
        String id = PhoneService.createPhone(PhoneCreatingDtoImpl);
        Phone Phone = PhoneService.getProductById(id);
        return new ResponseEntity<>(Phone, HttpStatus.CREATED);
    }

    @GetMapping(path = "/search/sorted", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    ResponseEntity<List<PhoneResponseDtoImpl>> getFilteredPhoneDto(@RequestParam(required = false) Optional<BigDecimal> minPrice,
                                                                   @RequestParam(required = false) Optional<BigDecimal> maxPrice,
                                                                   @RequestParam(required = false) Optional<String> color,
                                                                   @RequestParam(required = false) Optional<String> brand,
                                                                   @RequestParam(required = false) Optional<Integer> memorySize,
                                                                   @RequestParam(required = false) Optional<String> country,
                                                                   @RequestParam(required = false) Optional<String> serial,
                                                                   @RequestParam(required = false) Optional<String> model,
                                                                   @RequestParam(required = false) Optional<String> size,
                                                                   @RequestParam(required = false) Optional<Integer> camerasNumber,
                                                                   @RequestParam(required = false) Optional<Boolean> available,
                                                                   @RequestParam(required = false) Optional<Boolean> isOnlineOrdering,
                                                                   @RequestParam(required = false) Optional<Boolean> isSoldByInstallments,
                                                                   @RequestParam(required = false) Optional<VacuumCleanerSortedFields> sortBy,
                                                                   @RequestParam(required = false) Optional<SortDirection> sortType) {

        setCriteria(minPrice, maxPrice, color, brand, memorySize, country, serial, model, size, camerasNumber, available, isOnlineOrdering, isSoldByInstallments);

        List<PhoneResponseDtoImpl> Phonees = PhoneSearchService.getSortedListByNameAscAndPriceDescOfResponseDto(phoneSearchCriteria, sortBy, sortType);

        return new ResponseEntity<>(Phonees, HttpStatus.OK);
    }

    private void setCriteria(Optional<BigDecimal> minPrice,
                             Optional<BigDecimal> maxPrice,
                             Optional<String> color,
                             Optional<String> brand,
                             Optional<Integer> memorySize,
                             Optional<String> country,
                             Optional<String> serial,
                             Optional<String> model,
                             Optional<String> size,
                             Optional<Integer> camerasNumber,
                             Optional<Boolean> available,
                             Optional<Boolean> isOnlineOrdering,
                             Optional<Boolean> isSoldByInstallments) {
        Optional<Brand> optionalBrand = Optional.ofNullable(brandService.getBrandByName(brand.orElse(null)));

        Optional<Color> optionalColor = Optional.ofNullable(colorService.getColorByName(color.orElse(null)));

        phoneSearchCriteria =  PhoneSearchCriteria.PhoneSearchCriteriaBuilder.aPhoneSearchCriteria().memorySize(memorySize)
                .brandName(optionalBrand)
                .colorName(optionalColor)
                .minPrice(minPrice)
                .maxPrice(maxPrice)
                .producingCountry(country)
                .serialNumber(serial)
                .modelName(model)
                .size(size)
                .camerasNumber(camerasNumber)
                .isAvailable(available)
                .isOnlineOrdering(isOnlineOrdering)
                .isSoldByInstallments(isSoldByInstallments)
                .build();
    }
}