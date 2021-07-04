package com.example.isandstesttask.repository;

import com.example.isandstesttask.entity.reference.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.UUID;

public interface ColorRepository extends JpaRepository<Color, UUID> {
    Optional<Color> findColorByColorName(String brandName);
}