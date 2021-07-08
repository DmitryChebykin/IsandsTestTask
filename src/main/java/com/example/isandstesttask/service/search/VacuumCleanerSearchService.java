package com.example.isandstesttask.service.search;

import com.example.isandstesttask.entity.dto.response.VacuumCleanerResponseDtoImpl;
import com.example.isandstesttask.entity.product.VacuumCleanerImpl;
import com.example.isandstesttask.filter.vacuumcleaner.VacuumCleanerSearchCriteria;
import com.example.isandstesttask.filter.vacuumcleaner.VacuumCleanerSpecification;
import com.example.isandstesttask.repository.product.VacuumCleanerRepository;
import com.example.isandstesttask.util.SortDirection;
import com.example.isandstesttask.util.TvBoxDtoMapper;
import com.example.isandstesttask.util.VacuumCleanerSortedFields;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VacuumCleanerSearchService {
    private VacuumCleanerRepository vacuumCleanerRepository;
    private TvBoxDtoMapper tvBoxDtoMapper;

    @Autowired
    public VacuumCleanerSearchService(VacuumCleanerRepository vacuumCleanerRepository, TvBoxDtoMapper tvBoxDtoMapper) {
        this.vacuumCleanerRepository = vacuumCleanerRepository;
        this.tvBoxDtoMapper = tvBoxDtoMapper;
    }

    public VacuumCleanerSearchService() {
    }

    public List<VacuumCleanerResponseDtoImpl> getSortedListByNameAscAndPriceDescOfResponseDto(VacuumCleanerSearchCriteria vacuumCleanerSearchCriteria, Optional<VacuumCleanerSortedFields> sortBy, Optional<SortDirection> sortType) {
        Specification<VacuumCleanerImpl> baseSpecification = VacuumCleanerSpecification.createVacuumCleanerSpecifications(vacuumCleanerSearchCriteria);

        Sort.TypedSort<VacuumCleanerImpl> productTypedSort = Sort.sort(VacuumCleanerImpl.class);

        Sort sort = sortType.orElse(SortDirection.ASC) == SortDirection.ASC
                ? productTypedSort.by(sortBy.orElse(VacuumCleanerSortedFields.MODEL_NAME).getS()).ascending()
                : productTypedSort.by(sortBy.orElse(VacuumCleanerSortedFields.MODEL_NAME).getS()).descending();

        List<VacuumCleanerImpl> vacuumCleanerList = vacuumCleanerRepository.findAll(baseSpecification, sort);

        List<VacuumCleanerResponseDtoImpl> all = new ArrayList();

        for (VacuumCleanerImpl vc : vacuumCleanerList) {
            new VacuumCleanerResponseDtoImpl();
            VacuumCleanerResponseDtoImpl vacuumCleanerResponseDto;
            vacuumCleanerResponseDto = tvBoxDtoMapper.VacuumAsDTO(vc);
            all.add(vacuumCleanerResponseDto);
        }

        return all;
    }
}