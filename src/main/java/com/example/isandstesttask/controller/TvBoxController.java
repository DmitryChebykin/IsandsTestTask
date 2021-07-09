package com.example.isandstesttask.controller;

import com.example.isandstesttask.entity.dto.create.TvBoxCreatingDtoImpl;
import com.example.isandstesttask.entity.dto.get.TvBoxGetDto;
import com.example.isandstesttask.entity.dto.response.TvBoxResponseDtoImpl;
import com.example.isandstesttask.entity.product.TvBox;
import com.example.isandstesttask.entity.reference.Brand;
import com.example.isandstesttask.entity.reference.Color;
import com.example.isandstesttask.filter.tvbox.TvBoxSearchCriteria;
import com.example.isandstesttask.service.BrandService;
import com.example.isandstesttask.service.ColorService;
import com.example.isandstesttask.service.TvBoxService;
import com.example.isandstesttask.service.search.TvBoxSearchService;
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
    private final TvBoxService tvBoxService;
    private final BrandService brandService;
    private final TvBoxSearchService tvBoxSearchService;
    private final ColorService colorService;
    private TvBoxSearchCriteria tvBoxSearchCriteria;

    @Autowired
    public TvBoxController(TvBoxService tvBoxService, BrandService brandService, TvBoxSearchService tvBoxSearchService, ColorService colorService, TvBoxSearchCriteria tvBoxSearchCriteria) {
        this.tvBoxService = tvBoxService;
        this.brandService = brandService;
        this.tvBoxSearchService = tvBoxSearchService;
        this.colorService = colorService;
        this.tvBoxSearchCriteria = tvBoxSearchCriteria;
    }

    @PostMapping(path = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<TvBox> addTvBox(@RequestBody TvBoxCreatingDtoImpl tvBoxCreatingDtoImpl) {
        String id = tvBoxService.createTvBox(tvBoxCreatingDtoImpl);
        TvBox tvBox = tvBoxService.getProductById(id);
        return new ResponseEntity<>(tvBox, HttpStatus.CREATED);
    }

    @GetMapping(path = "/search/sorted", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    ResponseEntity<List<TvBoxResponseDtoImpl>> getFilteredTvBoxDto(TvBoxGetDto tvBoxGetDto) {
        setCriteria(tvBoxGetDto);

        List<TvBoxResponseDtoImpl> tvBoxes = tvBoxSearchService.getSortedListByNameAscAndPriceDescOfResponseDto(tvBoxSearchCriteria, tvBoxGetDto.getSortBy(), tvBoxGetDto.getSortType());

        return new ResponseEntity<>(tvBoxes, HttpStatus.OK);
    }

     private void setCriteria(TvBoxGetDto tvBoxGetDto) {
        Optional<Brand> optionalBrand = Optional.ofNullable(brandService.getBrandByName(tvBoxGetDto.getBrand().orElse(null)));

        Optional<Color> optionalColor = Optional.ofNullable(colorService.getColorByName(tvBoxGetDto.getColor().orElse(null)));

        tvBoxSearchCriteria = TvBoxSearchCriteria.TvBoxSearchCriteriaBuilder.aTvBoxSearchCriteria()
                .category(tvBoxGetDto.getCategory())
                .brandName(optionalBrand)
                .colorName(optionalColor)
                .minPrice(tvBoxGetDto.getMinPrice())
                .maxPrice(tvBoxGetDto.getMaxPrice())
                .producingCountry(tvBoxGetDto.getCountry())
                .serialNumber(tvBoxGetDto.getSerial())
                .modelName(tvBoxGetDto.getModel())
                .size(tvBoxGetDto.getSize())
                .technology(tvBoxGetDto.getTechnology())
                .isAvailable(tvBoxGetDto.getAvailable())
                .isOnlineOrdering(tvBoxGetDto.getIsOnlineOrdering())
                .isSoldByInstallments(tvBoxGetDto.getIsSoldByInstallments())
                .build();
    }
}