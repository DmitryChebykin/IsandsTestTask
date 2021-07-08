package com.example.isandstesttask.filter.TvBox;

import com.example.isandstesttask.entity.TvBoxProduct;
import com.example.isandstesttask.entity.dto.response.TvBoxResponseDtoImpl;
import com.example.isandstesttask.repository.product.ProductRepository;
import com.example.isandstesttask.util.mapper.TvBoxDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class TvBoxSearchService {
    private ProductRepository productRepository;

    private TvBoxDtoMapper tvBoxDtoMapper;

    @Autowired
    public TvBoxSearchService(@Qualifier("tvBoxRepository") ProductRepository productRepository, TvBoxDtoMapper tvBoxDtoMapper) {
        this.productRepository = productRepository;
        this.tvBoxDtoMapper = tvBoxDtoMapper;
    }

    public List getSortedByNameAscAndPriceDescListTvBox(TvBoxSearchCriteria tvBoxSearchCriteria) {
        Specification<TvBoxProduct> baseSpecification = BaseSpecification.createTvBoxSpecifications(tvBoxSearchCriteria);
        Specification<TvBoxProduct> tvBoxSpecification = TvBoxSpecification.createTvBoxSpecifications(tvBoxSearchCriteria);
        baseSpecification.and(tvBoxSpecification);
        Sort.TypedSort<TvBoxProduct> tvBoxTypedSort = Sort.sort(TvBoxProduct.class);
        Sort sort = tvBoxTypedSort
                .by(TvBoxProduct::getModelName).ascending()
                .and(tvBoxTypedSort.by(TvBoxProduct::getPrice).descending());
        return productRepository.findAll(baseSpecification, sort);
    }

    public List<TvBoxResponseDtoImpl> getSortedListByNameAscAndPriceDescOfResponseDto(TvBoxSearchCriteria tvBoxSearchCriteria) {
        List<TvBoxProduct> all = getSortedByNameAscAndPriceDescListTvBox(tvBoxSearchCriteria);

        List<TvBoxResponseDtoImpl> list = new ArrayList<>();
        for (TvBoxProduct tv : all) {
            new TvBoxResponseDtoImpl();
            TvBoxResponseDtoImpl tvBoxResponseDto;
            tvBoxResponseDto = tvBoxDtoMapper.asDTO(tv);
            list.add(tvBoxResponseDto);
        }
        return list;
    }

    public List<TvBoxProduct> getUnsortedTvBox(TvBoxSearchCriteria tvBoxSearchCriteria) {
        Specification<TvBoxProduct> baseSpecification = BaseSpecification.createTvBoxSpecifications(tvBoxSearchCriteria);
        Specification<TvBoxProduct> tvBoxSpecification = TvBoxSpecification.createTvBoxSpecifications(tvBoxSearchCriteria);
        baseSpecification.and(tvBoxSpecification);
        return productRepository.findAll(baseSpecification);
    }
}