package com.example.isandstesttask.controller;

import com.example.isandstesttask.entity.dto.TvBoxDto;
import com.example.isandstesttask.entity.dto.TvBoxFilterDto;
import com.example.isandstesttask.entity.mapper.GenericMapper;
import com.example.isandstesttask.entity.product.TvBox;
import com.example.isandstesttask.service.TvBoxService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/product/tv")
public class TvBoxController {
    private TvBoxService tvBoxService;
    private GenericMapper<TvBox, TvBoxDto> tvBoxDtoGenericMapper;

    @Autowired
    public TvBoxController(TvBoxService tvBoxService, GenericMapper<TvBox, TvBoxDto> televisionProductMapper) {
        this.tvBoxService = tvBoxService;
        this.tvBoxDtoGenericMapper = televisionProductMapper;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<TvBox> createTV(@RequestBody TvBoxDto tvBoxDto) {
        String id = tvBoxService.createTvBox(tvBoxDtoGenericMapper.asEntity(tvBoxDto));
        TvBox tvBox = tvBoxService.getProductById(id);
        System.out.println(tvBox);
        return new ResponseEntity<>(tvBox, HttpStatus.CREATED);
    }

    @GetMapping
    ResponseEntity<List<TvBox>> getFilteredTvBox(TvBoxFilterDto tvBoxFilterDto) {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map =
                mapper.convertValue(tvBoxFilterDto, new TypeReference<Map<String, Object>>() {
                });
        List<TvBox> tvBoxes = tvBoxService.getAll();

        return new ResponseEntity<>(tvBoxes, HttpStatus.ACCEPTED);
    }
}