package com.example.isandstesttask.filter.TvBox;

import com.example.isandstesttask.entity.dto.BaseProductResponseDto;
import com.example.isandstesttask.util.mapper.DtoMapper;
import com.example.isandstesttask.entity.product.TvBox;
import com.example.isandstesttask.repository.product.TvBoxRepository;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TvBoxSearchService {
    @Resource
    private TvBoxRepository tvBoxRepository;
    @Resource
    private DtoMapper dtoMapper;

    public List<TvBox> getSortedListTvBox(TvBoxSearchCriteria tvBoxSearchCriteria) {
        Specification<TvBox> tvBoxSpecification = TvBoxSpecification.createTvBoxSpecifications(tvBoxSearchCriteria);
        Sort.TypedSort<TvBox> tvBoxTypedSort = Sort.sort(TvBox.class);
        Sort sort = tvBoxTypedSort
                .by(TvBox::getModelName).ascending()
                .and(tvBoxTypedSort.by(TvBox::getPrice).descending());
        return Optional.ofNullable(tvBoxRepository.findAll(tvBoxSpecification, sort)).orElse(new ArrayList<>(0));
    }

    public List<BaseProductResponseDto> getSortedListOfResponseDto(TvBoxSearchCriteria tvBoxSearchCriteria) {
        List<TvBox> all = getSortedListTvBox(tvBoxSearchCriteria);

        return all.stream().map(tv -> dtoMapper.asDTO(tv)).collect(Collectors.toList());
    }
}