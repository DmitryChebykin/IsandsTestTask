package com.example.isandstesttask.service.filter;

import com.example.isandstesttask.entity.product.TvBox;
import com.example.isandstesttask.repository.TvBoxRepository;
import org.springframework.data.jpa.domain.Specification;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class TvBoxSearchServiceImpl implements TvBoxSearchService {
    private TvBoxRepository tvBoxRepository;

    @Override
    public List<TvBox> searchTvBox(TvBoxSearchCriteria tvBoxSearchCriteria) {
        Specification<TvBox> tvBoxSpecification = TvBoxSpecification.createTvBoxSpecifications(tvBoxSearchCriteria);
        return this.tvBoxRepository.findAll(tvBoxSpecification);
    }

//    @Override
//    public List<Film> retrieveFilms(FilmSearchCriteria searchCriteria) {
//        Specification<Film> filmSpecifications = FilmSpecifications.createFilmSpecifications(searchCriteria);
//        return this.filmDao.findAll(filmSpecifications);
//    }

    @Override
    public Optional<TvBox> searchTvBox(UUID id) {
        return Optional.empty();
    }
}