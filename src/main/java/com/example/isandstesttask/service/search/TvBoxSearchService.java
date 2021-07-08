package com.example.isandstesttask.service.search;

import com.example.isandstesttask.entity.dto.response.TvBoxResponseDtoImpl;
import com.example.isandstesttask.entity.product.TvBoxImpl;
import com.example.isandstesttask.filter.tvbox.TvBoxSearchCriteria;
import com.example.isandstesttask.filter.metamodel.TvSpecification;
import com.example.isandstesttask.repository.product.TvBoxRepository;
import com.example.isandstesttask.util.mapper.TvBoxDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class TvBoxSearchService {
    private TvBoxRepository tvBoxRepository;

    private TvBoxDtoMapper tvBoxDtoMapper;

    @Autowired
    public TvBoxSearchService(TvBoxRepository tvBoxRepository, TvBoxDtoMapper tvBoxDtoMapper) {
        this.tvBoxRepository = tvBoxRepository;
        this.tvBoxDtoMapper = tvBoxDtoMapper;
    }

    public List<TvBoxImpl> getSortedByNameAscAndPriceDescListTvBox(TvBoxSearchCriteria tvBoxSearchCriteria) {
        Specification<TvBoxImpl> baseSpecification = TvSpecification.createBaseSpecifications(tvBoxSearchCriteria);
        Specification<TvBoxImpl> tvSpecification = TvSpecification.createTvBoxSpecifications(tvBoxSearchCriteria);
        baseSpecification.and(tvSpecification);

        Sort.TypedSort<TvBoxImpl> tvBoxTypedSort = Sort.sort(TvBoxImpl.class);
        Sort sort = tvBoxTypedSort
                .by(TvBoxImpl::getModelName).ascending()
                .and(tvBoxTypedSort.by(TvBoxImpl::getPrice).descending());
        List<TvBoxImpl> all = tvBoxRepository.findAll(baseSpecification, sort);

        return all;
    }

    public List<TvBoxResponseDtoImpl> getSortedListByNameAscAndPriceDescOfResponseDto(TvBoxSearchCriteria tvBoxSearchCriteria) {
        List<TvBoxImpl> all = getSortedByNameAscAndPriceDescListTvBox(tvBoxSearchCriteria);

        List<TvBoxResponseDtoImpl> list = new ArrayList<>();
        for (TvBoxImpl tv : all) {
            new TvBoxResponseDtoImpl();
            TvBoxResponseDtoImpl tvBoxResponseDto;
            tvBoxResponseDto = tvBoxDtoMapper.TvAsDTO(tv);
            list.add(tvBoxResponseDto);
        }
        return list;
    }

    public List<TvBoxImpl> getUnsortedTvBox(TvBoxSearchCriteria tvBoxSearchCriteria) {
        Specification<TvBoxImpl> baseSpecification = TvSpecification.createTvBoxSpecifications(tvBoxSearchCriteria);
        baseSpecification.and(baseSpecification);
        return tvBoxRepository.findAll(baseSpecification);
    }
}