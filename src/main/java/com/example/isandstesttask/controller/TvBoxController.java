package com.example.isandstesttask.controller;

import com.example.isandstesttask.entity.dto.create.TvBoxCreatingDto;
import com.example.isandstesttask.entity.dto.response.TvBoxResponseDtoImpl;
import com.example.isandstesttask.entity.mapper.GenericMapper;
import com.example.isandstesttask.entity.product.TvBox;
import com.example.isandstesttask.entity.reference.Brand;
import com.example.isandstesttask.entity.reference.Color;
import com.example.isandstesttask.filter.TvBox.TvBoxSearchCriteria;
import com.example.isandstesttask.filter.TvBox.TvBoxSearchService;
import com.example.isandstesttask.service.BrandService;
import com.example.isandstesttask.service.ColorService;
import com.example.isandstesttask.service.TvBoxService;
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
    private GenericMapper<TvBox, TvBoxCreatingDto> tvBoxDtoGenericMapper;
    private BrandService brandService;
    private TvBoxSearchService tvBoxSearchService;
    private ColorService colorService;
    private TvBoxSearchCriteria tvBoxSearchCriteria;

    @Autowired
    public TvBoxController(TvBoxService tvBoxService, GenericMapper<TvBox, TvBoxCreatingDto> tvBoxDtoGenericMapper, BrandService brandService, TvBoxSearchService tvBoxSearchService, ColorService colorService, TvBoxSearchCriteria tvBoxSearchCriteria) {
        this.tvBoxService = tvBoxService;
        this.tvBoxDtoGenericMapper = tvBoxDtoGenericMapper;
        this.brandService = brandService;
        this.tvBoxSearchService = tvBoxSearchService;
        this.colorService = colorService;
        this.tvBoxSearchCriteria = tvBoxSearchCriteria;
    }



    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<TvBox> createTV(@RequestBody TvBoxCreatingDto tvBoxCreatingDto) {
        String id = tvBoxService.createTvBox(tvBoxDtoGenericMapper.asEntity(tvBoxCreatingDto));
        TvBox tvBox = tvBoxService.getProductById(id);
        return new ResponseEntity<>(tvBox, HttpStatus.CREATED);
    }


    ResponseEntity<List<TvBox>> getFilteredTvBox(
            @RequestParam(required = false) Optional<BigDecimal> minPrice,
            @RequestParam(required = false) Optional<BigDecimal> maxPrice,
            @RequestParam(required = false) Optional<String> color,
            @RequestParam(required = false) Optional<String> brand,
            @RequestParam(required = false) Optional<String> category,
            @RequestParam(required = false) Optional<String> country,
            @RequestParam(required = false) Optional<String> serial,
            @RequestParam(required = false) Optional<String> model,
            @RequestParam(required = false) Optional<String> size,
            @RequestParam(required = false) Optional<String> technology) {

        setTvBoxSearchCriteria(minPrice, maxPrice, color, brand, category, country, serial, model, size, technology);

        List<TvBox> tvBoxes = tvBoxSearchService.searchTvBox(tvBoxSearchCriteria);

        return new ResponseEntity<>(tvBoxes, HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    ResponseEntity<List<TvBoxResponseDtoImpl>> getFilteredTvBoxDto(
            @RequestParam(required = false) Optional<BigDecimal> minPrice,
            @RequestParam(required = false) Optional<BigDecimal> maxPrice,
            @RequestParam(required = false) Optional<String> color,
            @RequestParam(required = false) Optional<String> brand,
            @RequestParam(required = false) Optional<String> category,
            @RequestParam(required = false) Optional<String> country,
            @RequestParam(required = false) Optional<String> serial,
            @RequestParam(required = false) Optional<String> model,
            @RequestParam(required = false) Optional<String> size,
            @RequestParam(required = false) Optional<String> technology) {

        setTvBoxSearchCriteria(minPrice, maxPrice, color, brand, category, country, serial, model, size, technology);


        List<TvBoxResponseDtoImpl> tvBoxes = tvBoxSearchService.getListTvBoxResponseDtoImpl(tvBoxSearchCriteria);

        return new ResponseEntity<>(tvBoxes, HttpStatus.OK);
    }

    private void setTvBoxSearchCriteria(Optional<BigDecimal> minPrice,
                                        Optional<BigDecimal> maxPrice,
                                        Optional<String> color,
                                        Optional<String> brand,
                                        Optional<String> category,
                                        Optional<String> country,
                                        Optional<String> serial,
                                        Optional<String> model,
                                        Optional<String> size,
                                        Optional<String> technology) {
        Optional<Brand> optionalBrand = Optional.ofNullable(brandService.getBrandByName(brand.orElse(null)));

        Optional<Color> optionalColor = Optional.ofNullable(colorService.getColorByName(color.orElse(null)));

         tvBoxSearchCriteria = TvBoxSearchCriteria.TvBoxSearchCriteriaBuilder.aTvBoxSearchCriteria()
                .category(category)
                .brandName(optionalBrand)
                .colorName(optionalColor)
                .minPrice(minPrice)
                .maxPrice(maxPrice)
                .producingCountry(country)
                .serialNumber(serial)
                .modelName(model)
                .size(size)
                .technology(technology)
                .build();
    }
}