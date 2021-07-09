package com.example.isandstesttask.service.search;


import com.example.isandstesttask.repository.product.RefrigeratorRepository;
import com.example.isandstesttask.test.RefrigeratorImpl;
import com.example.isandstesttask.entity.dto.response.RefrigeratorResponseDtoImpl;
import com.example.isandstesttask.filter.refrigerator.RefrigeratorSearchCriteria;
import com.example.isandstesttask.filter.refrigerator.RefrigeratorSpecification;
import com.example.isandstesttask.util.DtoMapper;
import com.example.isandstesttask.util.SortDirection;
import com.example.isandstesttask.util.VacuumCleanerSortedFields;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RefrigeratorSearchService {
    private RefrigeratorRepository refrigeratorRepository;

    private DtoMapper dtoMapper;

    @Autowired
    public RefrigeratorSearchService(RefrigeratorRepository refrigeratorRepository, DtoMapper dtoMapper) {
        this.refrigeratorRepository = refrigeratorRepository;
        this.dtoMapper = dtoMapper;
    }

    public List<RefrigeratorResponseDtoImpl> getSortedListByNameAscAndPriceDescOfResponseDto(RefrigeratorSearchCriteria refrigeratorSearchCriteria, Optional<VacuumCleanerSortedFields> sortBy, Optional<SortDirection> sortType) {
        Specification<RefrigeratorImpl> tvSpecification = RefrigeratorSpecification.createRefrigeratorSpecification(refrigeratorSearchCriteria);

        Sort.TypedSort<RefrigeratorImpl> refrigeratorTypedSort = Sort.sort(RefrigeratorImpl.class);

        Sort sort = sortType.orElse(SortDirection.ASC) == SortDirection.ASC
                ? refrigeratorTypedSort.by(sortBy.orElse(VacuumCleanerSortedFields.MODEL_NAME).getS()).ascending()
                : refrigeratorTypedSort.by(sortBy.orElse(VacuumCleanerSortedFields.MODEL_NAME).getS()).descending();

        List<RefrigeratorImpl> all = refrigeratorRepository.findAll(tvSpecification, sort);

        List<RefrigeratorResponseDtoImpl> list = new ArrayList<>();
        for (RefrigeratorImpl ref : all) {
            new RefrigeratorResponseDtoImpl();
            RefrigeratorResponseDtoImpl refrigeratorResponseDto;
            refrigeratorResponseDto = dtoMapper.RefAsDTO(ref);
            list.add(refrigeratorResponseDto);
        }
        return list;
    }
}