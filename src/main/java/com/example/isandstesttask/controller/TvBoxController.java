package com.example.isandstesttask.controller;

import com.example.isandstesttask.entity.dto.create.TvBoxDto;
import com.example.isandstesttask.entity.dto.request.TvBoxFilterDto;
import com.example.isandstesttask.entity.dto.response.TvBoxResponseDto;
import com.example.isandstesttask.entity.product.TvBox;
import com.example.isandstesttask.entity.reference.Brand;
import com.example.isandstesttask.entity.reference.Color;
import com.example.isandstesttask.service.reference.BrandService;
import com.example.isandstesttask.service.reference.ColorService;
import com.example.isandstesttask.service.TvBoxService;
import com.example.isandstesttask.service.filter.TvBox.TvBoxSearchCriteria;
import com.example.isandstesttask.service.filter.TvBox.TvBoxSearchService;
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
    private BrandService brandService;
    private TvBoxSearchService tvBoxSearchService;
    private ColorService colorService;

    @Autowired
    public TvBoxController(TvBoxService tvBoxService, BrandService brandService, TvBoxSearchService tvBoxSearchService, ColorService colorService) {
        this.tvBoxService = tvBoxService;
        this.brandService = brandService;
        this.tvBoxSearchService = tvBoxSearchService;
        this.colorService = colorService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<TvBox> createTV(@RequestBody TvBoxDto tvBoxDto) {
        String id = tvBoxService.createTvBox(tvBoxDto);
        TvBox tvBox = tvBoxService.getProductById(id);
        return new ResponseEntity<>(tvBox, HttpStatus.CREATED);
    }

    ResponseEntity<TvBoxResponseDto> createTvBox(@RequestBody TvBoxDto tvBoxDto) {
        String id = tvBoxService.createTvBox(tvBoxDto);
        TvBox tvBox = tvBoxService.getProductById(id);
        TvBoxResponseDto tvBoxResponseDto = tvBoxService.getResponseDto(tvBox);
        return new ResponseEntity<>(tvBoxResponseDto, HttpStatus.CREATED);
    }

    @GetMapping(path = "/param" , produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<TvBox>> getFilteredTvBoxByRequestParam(
            @RequestParam(required = false) Optional<BigDecimal> minPrice,
            @RequestParam(required = false) Optional<BigDecimal> maxPrice,
            @RequestParam(required = false) Optional<String> color,
            @RequestParam(required = false) Optional<String> brand,
            @RequestParam(required = false) Optional<String> category,
            @RequestParam(required = false) Optional<String> country,
            @RequestParam(required = false) Optional<String> serial,
            @RequestParam(required = false) Optional<String> model,
            @RequestParam(required = false) Optional<String> technology) {

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
                .modelName(model)
                .technology(technology)
                .build();

        List<TvBox> tvBoxes = tvBoxSearchService.filterTvBox(tvBoxSearchCriteria);

        return new ResponseEntity<>(tvBoxes, HttpStatus.OK);
    }

    @GetMapping(path = "/dto", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<TvBoxResponseDto>> getFilteredTvBoxByDtoRequest(TvBoxFilterDto tvBoxFilterDto) {
        List<TvBoxResponseDto> tvBoxes = tvBoxSearchService.filterTvBox(tvBoxFilterDto);

        return new ResponseEntity<>(tvBoxes, HttpStatus.OK);
    }
}