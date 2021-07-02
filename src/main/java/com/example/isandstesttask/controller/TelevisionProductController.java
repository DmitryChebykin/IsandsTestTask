package com.example.isandstesttask.controller;

import com.example.isandstesttask.entity.dto.TelevisionProductDto;
import com.example.isandstesttask.entity.mapper.GenericMapper;
import com.example.isandstesttask.entity.product.TelevisionProduct;
import com.example.isandstesttask.service.TelevisionProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product/tv")
public class TelevisionProductController {
    private TelevisionProductService televisionProductService;
    private GenericMapper<TelevisionProduct, TelevisionProductDto> televisionProductMapper;

    @Autowired
    public TelevisionProductController(TelevisionProductService televisionProductService, GenericMapper<TelevisionProduct, TelevisionProductDto> televisionProductMapper) {
        this.televisionProductService = televisionProductService;
        this.televisionProductMapper = televisionProductMapper;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    ResponseEntity<TelevisionProduct> createTV(@RequestBody TelevisionProductDto televisionProductDto) {
        String id = televisionProductService.createTelevisionProduct(televisionProductMapper.asEntity(televisionProductDto)).toString();
        return new ResponseEntity<>(televisionProductService.getProductById(id), HttpStatus.CREATED);
    }
}