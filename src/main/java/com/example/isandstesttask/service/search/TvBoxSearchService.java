package com.example.isandstesttask.service.search;

import com.example.isandstesttask.entity.dto.response.TvBoxResponseDtoImpl;
import com.example.isandstesttask.entity.product.TvBoxImpl;
import com.example.isandstesttask.filter.tvbox.TvBoxSearchCriteria;
import com.example.isandstesttask.filter.tvbox.TvSpecification;
import com.example.isandstesttask.repository.product.TvBoxRepository;
import com.example.isandstesttask.util.SortDirection;
import com.example.isandstesttask.util.DtoMapper;
import com.example.isandstesttask.util.VacuumCleanerSortedFields;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TvBoxSearchService {
    private TvBoxRepository tvBoxRepository;

    private DtoMapper dtoMapper;

    @Autowired
    public TvBoxSearchService(TvBoxRepository tvBoxRepository, DtoMapper dtoMapper) {
        this.tvBoxRepository = tvBoxRepository;
        this.dtoMapper = dtoMapper;
    }

    public List<TvBoxResponseDtoImpl> getSortedListByNameAscAndPriceDescOfResponseDto(TvBoxSearchCriteria tvBoxSearchCriteria, Optional<VacuumCleanerSortedFields> sortBy, Optional<SortDirection> sortType) {
        Specification<TvBoxImpl> tvSpecification = TvSpecification.createTvBoxSpecification(tvBoxSearchCriteria);

        Sort.TypedSort<TvBoxImpl> tvBoxTypedSort = Sort.sort(TvBoxImpl.class);

        Sort sort = sortType.orElse(SortDirection.ASC) == SortDirection.ASC
                ? tvBoxTypedSort.by(sortBy.orElse(VacuumCleanerSortedFields.MODEL_NAME).getS()).ascending()
                : tvBoxTypedSort.by(sortBy.orElse(VacuumCleanerSortedFields.MODEL_NAME).getS()).descending();

        List<TvBoxImpl> all = tvBoxRepository.findAll(tvSpecification, sort);

        List<TvBoxResponseDtoImpl> list = new ArrayList<>();
        for (TvBoxImpl tv : all) {
            new TvBoxResponseDtoImpl();
            TvBoxResponseDtoImpl tvBoxResponseDto;
            tvBoxResponseDto = dtoMapper.TvAsDTO(tv);
            list.add(tvBoxResponseDto);
        }
        return list;
    }
}