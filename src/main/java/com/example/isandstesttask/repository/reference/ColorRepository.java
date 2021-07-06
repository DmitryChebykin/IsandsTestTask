package com.example.isandstesttask.repository.reference;

import com.example.isandstesttask.entity.reference.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ColorRepository extends JpaRepository<Color, UUID> {
    Optional<Color> findColorByColorName(String brandName);
}