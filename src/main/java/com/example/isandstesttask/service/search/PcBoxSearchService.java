package com.example.isandstesttask.service.search;

import com.example.isandstesttask.entity.dto.response.PcBoxResponseDtoImpl;
import com.example.isandstesttask.filter.pc.PcBoxSearchCriteria;
import com.example.isandstesttask.filter.pc.PcBoxSpecification;
import com.example.isandstesttask.repository.product.PcBoxRepository;
import com.example.isandstesttask.test.PcBoxImpl;
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
public class PcBoxSearchService {
    private PcBoxRepository PcBoxRepository;

    private DtoMapper<PcBoxImpl> dtoMapper;

    @Autowired
    public PcBoxSearchService(PcBoxRepository PcBoxRepository, @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection") DtoMapper<PcBoxImpl> dtoMapper) {
        this.PcBoxRepository = PcBoxRepository;
        this.dtoMapper = dtoMapper;
    }

    public List<PcBoxResponseDtoImpl> getSortedListByNameAscAndPriceDescOfResponseDto(PcBoxSearchCriteria PcBoxSearchCriteria, Optional<VacuumCleanerSortedFields> sortBy, Optional<SortDirection> sortType) {
        Specification<PcBoxImpl> tvSpecification = PcBoxSpecification.createPcBoxSpecification(PcBoxSearchCriteria);

        Sort.TypedSort<PcBoxImpl> PcBoxTypedSort = Sort.sort(PcBoxImpl.class);

        Sort sort = sortType.orElse(SortDirection.ASC) == SortDirection.ASC
                ? PcBoxTypedSort.by(sortBy.orElse(VacuumCleanerSortedFields.MODEL_NAME).getS()).ascending()
                : PcBoxTypedSort.by(sortBy.orElse(VacuumCleanerSortedFields.MODEL_NAME).getS()).descending();

        List<PcBoxImpl> all = PcBoxRepository.findAll(tvSpecification, sort);

        List<PcBoxResponseDtoImpl> list = new ArrayList<>();
        for (PcBoxImpl pcBox : all) {
            new PcBoxResponseDtoImpl();
            PcBoxResponseDtoImpl PcBoxResponseDto;
            PcBoxResponseDto = dtoMapper.PcBoxAsDTO(pcBox);
            list.add(PcBoxResponseDto);
        }
        return list;
    }
}