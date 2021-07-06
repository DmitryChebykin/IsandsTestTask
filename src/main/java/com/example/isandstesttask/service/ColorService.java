package com.example.isandstesttask.service;

import com.example.isandstesttask.entity.reference.Color;
import com.example.isandstesttask.repository.reference.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ColorService {
    private ColorRepository colorRepository;

    @Autowired
    public ColorService(ColorRepository colorRepository) {
        this.colorRepository = colorRepository;
    }

    public Color getColorByName(String colorName) {
        return colorRepository.findColorByColorName(colorName).orElse(null);
    }
}