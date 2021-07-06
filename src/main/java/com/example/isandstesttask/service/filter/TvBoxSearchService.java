package com.example.isandstesttask.service.filter;

import com.example.isandstesttask.entity.product.TvBox;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public interface TvBoxSearchService {
    List<TvBox> searchTvBox (TvBoxSearchCriteria tvBoxSearchCriteria);

    Optional<TvBox> searchTvBox (UUID id);
}