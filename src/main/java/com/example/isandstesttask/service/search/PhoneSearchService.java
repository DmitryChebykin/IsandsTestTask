package com.example.isandstesttask.service.search;

import com.example.isandstesttask.entity.dto.response.PhoneResponseDtoImpl;
import com.example.isandstesttask.entity.product.PhoneImpl;
import com.example.isandstesttask.filter.phone.PhoneSearchCriteria;
import com.example.isandstesttask.filter.phone.PhoneSpecification;
import com.example.isandstesttask.repository.product.PhoneRepository;
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
public class PhoneSearchService {
    private PhoneRepository phoneRepository;

    private DtoMapper<PhoneImpl> dtoMapper;

    @Autowired
    public PhoneSearchService(PhoneRepository PhoneRepository, @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection") DtoMapper<PhoneImpl> dtoMapper) {
        this.phoneRepository = PhoneRepository;
        this.dtoMapper = dtoMapper;
    }

    public List<PhoneResponseDtoImpl> getSortedListByNameAscAndPriceDescOfResponseDto(PhoneSearchCriteria PhoneSearchCriteria, Optional<VacuumCleanerSortedFields> sortBy, Optional<SortDirection> sortType) {
        Specification<PhoneImpl> tvSpecification = PhoneSpecification.createPhoneSpecification(PhoneSearchCriteria);

        Sort.TypedSort<PhoneImpl> PhoneTypedSort = Sort.sort(PhoneImpl.class);

        Sort sort = sortType.orElse(SortDirection.ASC) == SortDirection.ASC
                ? PhoneTypedSort.by(sortBy.orElse(VacuumCleanerSortedFields.MODEL_NAME).getS()).ascending()
                : PhoneTypedSort.by(sortBy.orElse(VacuumCleanerSortedFields.MODEL_NAME).getS()).descending();

        List<PhoneImpl> all = phoneRepository.findAll(tvSpecification, sort);

        List<PhoneResponseDtoImpl> list = new ArrayList<>();
        for (PhoneImpl ref : all) {
            new PhoneResponseDtoImpl();
            PhoneResponseDtoImpl PhoneResponseDto;
            PhoneResponseDto = dtoMapper.PhoneAsDTO(ref);
            list.add(PhoneResponseDto);
        }
        return list;
    }
}