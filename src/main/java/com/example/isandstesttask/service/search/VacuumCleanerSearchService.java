package com.example.isandstesttask.service.search;

import com.example.isandstesttask.entity.dto.response.VacuumCleanerResponseDtoImpl;
import com.example.isandstesttask.entity.product.VacuumCleanerImpl;
import com.example.isandstesttask.filter.VacuumCleanerSpecification;
import com.example.isandstesttask.filter.tvbox.VacuumCleanerSearchCriteria;
import com.example.isandstesttask.repository.product.VacuumCleanerRepository;
import com.example.isandstesttask.util.mapper.TvBoxDtoMapper;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class VacuumCleanerSearchService {
    private VacuumCleanerRepository vacuumCleanerRepository;
    private TvBoxDtoMapper tvBoxDtoMapper;



    public List<VacuumCleanerImpl> getUnsortedTvBox(VacuumCleanerSearchCriteria vacuumCleanerSearchCriteria) {
        return null;
    }

    public List<VacuumCleanerImpl> getSortedByNameAscAndPriceDescListTvBox(VacuumCleanerSearchCriteria vacuumCleanerSearchCriteria) {
        Specification<VacuumCleanerImpl> baseSpecification = VacuumCleanerSpecification.createVacuumCleanerSpecifications(vacuumCleanerSearchCriteria);

        Sort.TypedSort<VacuumCleanerImpl> productTypedSort = Sort.sort(VacuumCleanerImpl.class);

        Sort sort = productTypedSort
                .by(VacuumCleanerImpl::getModelName).ascending()
                .and(productTypedSort.by(VacuumCleanerImpl::getPrice).descending());

        List<VacuumCleanerImpl> all = vacuumCleanerRepository.findAll(baseSpecification, sort);

        System.out.println();

        return all;
    }

    public List<VacuumCleanerResponseDtoImpl> getSortedListByNameAscAndPriceDescOfResponseDto(VacuumCleanerSearchCriteria vacuumCleanerSearchCriteria) {
        Specification<VacuumCleanerImpl> baseSpecification = VacuumCleanerSpecification.createVacuumCleanerSpecifications(vacuumCleanerSearchCriteria);

        Sort.TypedSort<VacuumCleanerImpl> productTypedSort = Sort.sort(VacuumCleanerImpl.class);

        Sort sort = productTypedSort
                .by(VacuumCleanerImpl::getModelName).ascending()
                .and(productTypedSort.by(VacuumCleanerImpl::getPrice).descending());
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