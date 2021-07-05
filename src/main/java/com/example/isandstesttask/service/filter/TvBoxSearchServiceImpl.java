package com.example.isandstesttask.service.filter;

import com.example.isandstesttask.entity.product.TvBox;
import com.example.isandstesttask.repository.TvBoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TvBoxSearchServiceImpl implements TvBoxSearchService {
    @Autowired
    private TvBoxRepository tvBoxRepository;

    @Override
    public List<TvBox> searchTvBox(TvBoxSearchCriteria tvBoxSearchCriteria) {
        Specification<TvBox> tvBoxSpecification = TvBoxSpecification.createTvBoxSpecifications(tvBoxSearchCriteria);
        return tvBoxRepository.findAll(tvBoxSpecification);
    }

    @Override
    public Optional<TvBox> searchTvBox(UUID id) {
        return tvBoxRepository.findById(id);
    }
}