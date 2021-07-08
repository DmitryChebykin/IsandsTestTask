package com.example.isandstesttask.test;

import com.example.isandstesttask.entity.reference.Brand;
import com.example.isandstesttask.entity.reference.Color;
import com.example.isandstesttask.service.BrandService;
import com.example.isandstesttask.service.ColorService;
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
@RequestMapping("/product/refrigerator")
public class RefrigeratorController {
    private final RefrigeratorService refrigeratorService;
    private final BrandService brandService;
    private final RefrigeratorSearchService refrigeratorSearchService;
    private final ColorService colorService;
    private RefrigeratorSearchCriteria refrigeratorSearchCriteria;

    @Autowired
    public RefrigeratorController(RefrigeratorService refrigeratorService, BrandService brandService, RefrigeratorSearchService refrigeratorSearchService, ColorService colorService, RefrigeratorSearchCriteria refrigeratorSearchCriteria) {
        this.refrigeratorService = refrigeratorService;
        this.brandService = brandService;
        this.refrigeratorSearchService = refrigeratorSearchService;
        this.colorService = colorService;
        this.refrigeratorSearchCriteria = refrigeratorSearchCriteria;
    }

    @PostMapping(path = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Refrigerator> addRefrigerator(@RequestBody RefrigeratorCreatingDtoImpl refrigeratorCreatingDtoImpl) {
        String id = refrigeratorService.createRefrigerator(refrigeratorCreatingDtoImpl);
        Refrigerator refrigerator = refrigeratorService.getProductById(id);
        return new ResponseEntity<>(refrigerator, HttpStatus.CREATED);
    }

    @GetMapping(path = "/search/sorted", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    ResponseEntity<List<RefrigeratorResponseDtoImpl>> getFilteredRefrigeratorDto(@RequestParam(required = false) Optional<BigDecimal> minPrice,
                                                                   @RequestParam(required = false) Optional<BigDecimal> maxPrice,
                                                                   @RequestParam(required = false) Optional<String> color,
                                                                   @RequestParam(required = false) Optional<String> brand,
                                                                   @RequestParam(required = false) Optional<String> category,
                                                                   @RequestParam(required = false) Optional<String> country,
                                                                   @RequestParam(required = false) Optional<String> serial,
                                                                   @RequestParam(required = false) Optional<String> model,
                                                                   @RequestParam(required = false) Optional<String> size,
                                                                   @RequestParam(required = false) Optional<String> technology,
                                                                   @RequestParam(required = false) Optional<Boolean> available,
                                                                   @RequestParam(required = false) Optional<Boolean> isOnlineOrdering,
                                                                   @RequestParam(required = false) Optional<Boolean> isSoldByInstallments,
                                                                   @RequestParam(required = false) Optional<VacuumCleanerSortedFields> sortBy,
                                                                   @RequestParam(required = false) Optional<SortDirection> sortType) {

        setCriteria(minPrice, maxPrice, color, brand, category, country, serial, model, size, technology, available, isOnlineOrdering, isSoldByInstallments);

        List<RefrigeratorResponseDtoImpl> refrigeratores = refrigeratorSearchService.getSortedListByNameAscAndPriceDescOfResponseDto(refrigeratorSearchCriteria, sortBy, sortType);

        return new ResponseEntity<>(refrigeratores, HttpStatus.OK);
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
                             Optional<String> technology,
                             Optional<Boolean> available,
                             Optional<Boolean> isOnlineOrdering,
                             Optional<Boolean> isSoldByInstallments) {
        Optional<Brand> optionalBrand = Optional.ofNullable(brandService.getBrandByName(brand.orElse(null)));

        Optional<Color> optionalColor = Optional.ofNullable(colorService.getColorByName(color.orElse(null)));

        refrigeratorSearchCriteria = RefrigeratorSearchCriteria.RefrigeratorSearchCriteriaBuilder.aRefrigeratorSearchCriteria().category(category)
                .brandName(optionalBrand)
                .colorName(optionalColor)
                .minPrice(minPrice)
                .maxPrice(maxPrice)
                .producingCountry(country)
                .serialNumber(serial)
                .modelName(model)
                .size(size)
                .technology(technology)
                .isAvailable(available)
                .isOnlineOrdering(isOnlineOrdering)
                .isSoldByInstallments(isSoldByInstallments)
                .build();
    }
}