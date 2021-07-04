package com.example.isandstesttask.service.filter;

import com.example.isandstesttask.entity.product.TvBox;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TvBoxSearchService {
    List<TvBox> searchTvBox (TvBoxSearchCriteria tvBoxSearchCriteria);

    Optional<TvBox> searchTvBox (UUID id);
}