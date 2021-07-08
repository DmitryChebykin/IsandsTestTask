package com.example.isandstesttask.filter.TvBox;

import com.example.isandstesttask.entity.dto.response.TvBoxResponseDtoImpl;
import com.example.isandstesttask.entity.reference.Product;
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
        Specification<Product> baseSpecification = ProductSpecification.createTvBoxSpecifications(tvBoxSearchCriteria);

        Sort.TypedSort<Product> tvBoxTypedSort = Sort.sort(Product.class);
        Sort sort = tvBoxTypedSort
                .by(Product::getModelName).ascending()
                .and(tvBoxTypedSort.by(Product::getPrice).descending());
        return productRepository.findAll(baseSpecification, sort);
    }

    public List<TvBoxResponseDtoImpl> getSortedListByNameAscAndPriceDescOfResponseDto(TvBoxSearchCriteria tvBoxSearchCriteria) {
        List<Product> all = getSortedByNameAscAndPriceDescListTvBox(tvBoxSearchCriteria);

        List<TvBoxResponseDtoImpl> list = new ArrayList<>();
        for (Product tv : all) {
            new TvBoxResponseDtoImpl();
            TvBoxResponseDtoImpl tvBoxResponseDto;
            tvBoxResponseDto = tvBoxDtoMapper.asDTO(tv);
            list.add(tvBoxResponseDto);
        }
        return list;
    }

    public List<Product> getUnsortedTvBox(TvBoxSearchCriteria tvBoxSearchCriteria) {
        Specification<Product> baseSpecification = ProductSpecification.createTvBoxSpecifications(tvBoxSearchCriteria);
        baseSpecification.and(baseSpecification);
        return productRepository.findAll(baseSpecification);
    }
}