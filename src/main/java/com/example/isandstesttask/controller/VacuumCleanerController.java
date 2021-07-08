package com.example.isandstesttask.controller;

import com.example.isandstesttask.entity.dto.create.VacuumCleanerCreatingDtoImpl;
import com.example.isandstesttask.entity.dto.response.VacuumCleanerResponseDtoImpl;
import com.example.isandstesttask.entity.product.VacuumCleanerImpl;
import com.example.isandstesttask.entity.reference.Brand;
import com.example.isandstesttask.entity.reference.Color;
import com.example.isandstesttask.filter.vacuumcleaner.VacuumCleanerSearchCriteria;
import com.example.isandstesttask.service.BrandService;
import com.example.isandstesttask.service.ColorService;
import com.example.isandstesttask.service.VacuumCleanerService;
import com.example.isandstesttask.service.search.VacuumCleanerSearchService;
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
@RequestMapping("/product/cleaner")
public class VacuumCleanerController {
    private VacuumCleanerSearchCriteria vacuumCleanerSearchCriteria;
    private VacuumCleanerService vacuumCleanerService;
    private VacuumCleanerSearchService vacuumCleanerSearchService;
    private BrandService brandService;
    private ColorService colorService;

    @Autowired
    public VacuumCleanerController(VacuumCleanerService vacuumCleanerService, VacuumCleanerSearchService vacuumCleanerSearchService, BrandService brandService, ColorService colorService, VacuumCleanerSearchCriteria vacuumCleanerSearchCriteria) {
        this.vacuumCleanerService = vacuumCleanerService;
        this.vacuumCleanerSearchService = vacuumCleanerSearchService;
        this.brandService = brandService;
        this.colorService = colorService;
        this.vacuumCleanerSearchCriteria = vacuumCleanerSearchCriteria;
    }

    @PostMapping(path = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<VacuumCleanerImpl> addVacuumCleaner(@RequestBody VacuumCleanerCreatingDtoImpl vacuumCleanerCreatingDto) {
        String id = vacuumCleanerService.addVacuumCleaner(vacuumCleanerCreatingDto);
        VacuumCleanerImpl vacuumCleaner = vacuumCleanerService.getProductById(id);
        return new ResponseEntity<>(vacuumCleaner, HttpStatus.CREATED);
    }

    @GetMapping(path = "/search/sorted", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    ResponseEntity<List<VacuumCleanerResponseDtoImpl>> getFilteredCleanerDto(@RequestParam(required = false) Optional<BigDecimal> minPrice,
                                                                             @RequestParam(required = false) Optional<BigDecimal> maxPrice,
                                                                             @RequestParam(required = false) Optional<String> color,
                                                                             @RequestParam(required = false) Optional<String> brand,
                                                                             @RequestParam(required = false) Optional<BigDecimal> dustContainerVolume,
                                                                             @RequestParam(required = false) Optional<String> country,
                                                                             @RequestParam(required = false) Optional<String> serial,
                                                                             @RequestParam(required = false) Optional<String> model,
                                                                             @RequestParam(required = false) Optional<String> size,
                                                                             @RequestParam(required = false) Optional<Integer> modesNumber,
                                                                             @RequestParam(required = false) Optional<Boolean> available,
                                                                             @RequestParam(required = false) Optional<Boolean> isOnlineOrdering,
                                                                             @RequestParam(required = false) Optional<Boolean> isSoldByInstallments,
                                                                             @RequestParam(required = false) Optional<VacuumCleanerSortedFields> sortBy,
                                                                             @RequestParam(required = false) Optional<SortDirection> sortType) {

        setCriteria(minPrice, maxPrice, color, brand, dustContainerVolume, country, serial, model, size, modesNumber, available, isOnlineOrdering, isSoldByInstallments);

        List<VacuumCleanerResponseDtoImpl> tvBoxes = vacuumCleanerSearchService.getSortedListByNameAscAndPriceDescOfResponseDto(vacuumCleanerSearchCriteria, sortBy, sortType);

        return new ResponseEntity<>(tvBoxes, HttpStatus.OK);
    }

    private void setCriteria(Optional<BigDecimal> minPrice,
                             Optional<BigDecimal> maxPrice,
                             Optional<String> color,
                             Optional<String> brand,
                             Optional<BigDecimal> DustContainerVolume,
                             Optional<String> country,
                             Optional<String> serial,
                             Optional<String> model,
                             Optional<String> size,
                             Optional<Integer> ModesNumber,
                             Optional<Boolean> available,
                             Optional<Boolean> isOnlineOrdering,
                             Optional<Boolean> isSoldByInstallments) {
        Optional<Brand> optionalBrand = Optional.ofNullable(brandService.getBrandByName(brand.orElse(null)));

        Optional<Color> optionalColor = Optional.ofNullable(colorService.getColorByName(color.orElse(null)));

        vacuumCleanerSearchCriteria = VacuumCleanerSearchCriteria.VacuumCleanerSearchCriteriaBuilder.aVacuumCleanerSearchCriteria()
                .DustContainerVolume(DustContainerVolume)
                .brandName(optionalBrand)
                .colorName(optionalColor)
                .minPrice(minPrice)
                .maxPrice(maxPrice)
                .producingCountry(country)
                .serialNumber(serial)
                .modelName(model)
                .size(size)
                .ModesNumber(ModesNumber)
                .isAvailable(available)
                .isOnlineOrdering(isOnlineOrdering)
                .isSoldByInstallments(isSoldByInstallments)
                .build();
    }
}