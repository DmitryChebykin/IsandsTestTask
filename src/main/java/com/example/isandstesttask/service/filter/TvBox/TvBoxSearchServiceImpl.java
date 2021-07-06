package com.example.isandstesttask.service.filter.TvBox;

import com.example.isandstesttask.entity.dto.request.TvBoxFilterDto;
import com.example.isandstesttask.entity.dto.response.TvBoxResponseDto;
import com.example.isandstesttask.entity.product.TvBox;
import com.example.isandstesttask.entity.reference.Brand;
import com.example.isandstesttask.entity.reference.Color;
import com.example.isandstesttask.repository.reference.BrandRepository;
import com.example.isandstesttask.repository.reference.ColorRepository;
import com.example.isandstesttask.repository.reference.TvBoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class TvBoxSearchServiceImpl implements TvBoxSearchService {

    private TvBoxRepository tvBoxRepository;
    private BrandRepository brandRepository;
    private ColorRepository colorRepository;

    public TvBoxSearchServiceImpl(TvBoxRepository tvBoxRepository, BrandRepository brandRepository, ColorRepository colorRepository) {
        this.tvBoxRepository = tvBoxRepository;
        this.brandRepository = brandRepository;
        this.colorRepository = colorRepository;
    }

    @Autowired

    public TvBoxSearchServiceImpl() {
    }

    @Override
    public List<TvBox> filterTvBox(TvBoxSearchCriteria tvBoxSearchCriteria) {
        Specification<TvBox> tvBoxSpecification = TvBoxSpecification.createTvBoxSpecifications(tvBoxSearchCriteria);

        Sort.TypedSort<TvBox> tvBoxTypedSort = Sort.sort(TvBox.class);

        Sort sort = tvBoxTypedSort
                .by(TvBox::getModelName).ascending()
                .and(tvBoxTypedSort.by(TvBox::getPrice).descending());

        return tvBoxRepository.findAll(tvBoxSpecification, sort);
    }

    @Override
    public List<TvBoxResponseDto> filterTvBox(TvBoxFilterDto tvBoxFilterDto) {
        return null;
    }

    public List<TvBox> getListFilteredTvBox(TvBoxFilterDto tvBoxFilterDto) {
        TvBoxSearchCriteria tvBoxSearchCriteria = getTvBoxSearchCriteria(tvBoxFilterDto);

        return filterTvBox(tvBoxSearchCriteria);
    }

    private TvBoxSearchCriteria getTvBoxSearchCriteria(TvBoxFilterDto tvBoxFilterDto) {
        Optional<BigDecimal> minPrice = Optional.of(BigDecimal.valueOf(Long.parseLong(tvBoxFilterDto.getMinPrice())));
        Optional<BigDecimal> maxPrice = Optional.of(BigDecimal.valueOf(Long.parseLong(tvBoxFilterDto.getMaxPrice())));
        Optional<String> category = Optional.ofNullable(tvBoxFilterDto.getCategory());
        Optional<String> country = Optional.ofNullable(tvBoxFilterDto.getProducingCountry());
        Optional<String> serial = Optional.ofNullable(tvBoxFilterDto.getSerialNumber());
        Optional<String> model = Optional.ofNullable(tvBoxFilterDto.getModelName());
        Optional<String> technology = Optional.ofNullable(tvBoxFilterDto.getTechnology());

        Optional<Brand> optionalBrand = brandRepository.findByBrandName(tvBoxFilterDto.getBrandName());

        Optional<Color> optionalColor = colorRepository.findByColorName(tvBoxFilterDto.getColorName());

        return TvBoxSearchCriteria.TvBoxSearchCriteriaBuilder.aTvBoxSearchCriteria()
                .category(category)
                .brandName(optionalBrand)
                .colorName(optionalColor)
                .minPrice(minPrice)
                .maxPrice(maxPrice)
                .producingCountry(country)
                .serialNumber(serial)
                .modelName(model)
                .technology(technology)
                .build();
    }
}