package com.example.isandstesttask.controller;

import com.example.isandstesttask.entity.dto.TvBoxDto;
import com.example.isandstesttask.entity.mapper.GenericMapper;
import com.example.isandstesttask.entity.product.TvBox;
import com.example.isandstesttask.entity.reference.Brand;
import com.example.isandstesttask.entity.reference.Color;
import com.example.isandstesttask.service.BrandService;
import com.example.isandstesttask.service.ColorService;
import com.example.isandstesttask.service.TvBoxService;
import com.example.isandstesttask.service.filter.TvBoxSearchCriteria;
import com.example.isandstesttask.service.filter.TvBoxSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product/tv")
public class TvBoxController {
    private TvBoxService tvBoxService;
    private GenericMapper<TvBox, TvBoxDto> tvBoxDtoGenericMapper;
    private BrandService brandService;
    private TvBoxSearchService tvBoxSearchService;
    private ColorService colorService;

    @Autowired
    public TvBoxController(TvBoxService tvBoxService, GenericMapper<TvBox, TvBoxDto> tvBoxDtoGenericMapper, BrandService brandService, TvBoxSearchService tvBoxSearchService, ColorService colorService) {
        this.tvBoxService = tvBoxService;
        this.tvBoxDtoGenericMapper = tvBoxDtoGenericMapper;
        this.brandService = brandService;
        this.tvBoxSearchService = tvBoxSearchService;
        this.colorService = colorService;
    }



    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<TvBox> createTV(@RequestBody TvBoxDto tvBoxDto) {
        String id = tvBoxService.createTvBox(tvBoxDtoGenericMapper.asEntity(tvBoxDto));
        TvBox tvBox = tvBoxService.getProductById(id);
        System.out.println(tvBox);
        return new ResponseEntity<>(tvBox, HttpStatus.CREATED);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<TvBox>> getFilteredTvBox(
            @RequestParam(required = false) Optional<BigDecimal> minPrice,
            @RequestParam(required = false) Optional<BigDecimal> maxPrice,
            @RequestParam(required = false) Optional<String> color,
            @RequestParam(required = false) Optional<String> brand,
            @RequestParam(required = false) Optional<String> category,
            @RequestParam(required = false) Optional<String> country,
            @RequestParam(required = false) Optional<String> serial,
            @RequestParam(required = false) Optional<String> model) {

        Optional<Brand> optionalBrand = Optional.ofNullable(brandService.getBrandByName(brand.orElse(null)));


        Optional<Color> optionalColor = Optional.ofNullable(colorService.getColorByName(color.orElse(null)));


        TvBoxSearchCriteria tvBoxSearchCriteria = TvBoxSearchCriteria.TvBoxSearchCriteriaBuilder.aTvBoxSearchCriteria()
                .category(category)
                .brandName(optionalBrand)
                .colorName(optionalColor)
                .minPrice(minPrice)
                .maxPrice(maxPrice)
                .producingCountry(country)
                .serialNumber(serial)
                .modelName(model).build();

        List<TvBox> tvBoxes = tvBoxSearchService.searchTvBox(tvBoxSearchCriteria);

        return new ResponseEntity<>(tvBoxes, HttpStatus.OK);
    }
}