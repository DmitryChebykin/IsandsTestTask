package com.example.isandstesttask.filter.TvBox;

import com.example.isandstesttask.entity.dto.TvBoxResponseDto;
import com.example.isandstesttask.entity.dto.response.TvBoxResponseDtoImpl;
import com.example.isandstesttask.entity.product.TvBox;
import com.example.isandstesttask.repository.TvBoxRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TvBoxSearchService {
    private TvBoxRepository tvBoxRepository;

    @Autowired
    public TvBoxSearchService(TvBoxRepository tvBoxRepository) {
        this.tvBoxRepository = tvBoxRepository;
    }

    public TvBoxSearchService() {
    }

    public List<TvBox> searchTvBox(TvBoxSearchCriteria tvBoxSearchCriteria) {
        Specification<TvBox> tvBoxSpecification = TvBoxSpecification.createTvBoxSpecifications(tvBoxSearchCriteria);
        Sort.TypedSort<TvBox> tvBoxTypedSort = Sort.sort(TvBox.class);
        Sort sort = tvBoxTypedSort
                .by(TvBox::getModelName).ascending()
                .and(tvBoxTypedSort.by(TvBox::getPrice).descending());
        return tvBoxRepository.findAll(tvBoxSpecification, sort);
    }

    public List<TvBoxResponseDtoImpl> getListTvBoxResponseDtoImpl(TvBoxSearchCriteria tvBoxSearchCriteria) {

        searchTvBox(tvBoxSearchCriteria).stream().map(tv -> getDtoFromTvBox(tv)).collect(Collectors.toList());

        return searchTvBox(tvBoxSearchCriteria).stream().map(tv -> (TvBoxResponseDtoImpl)getDtoFromTvBox(tv)).collect(Collectors.toList());
    }

    private TvBoxResponseDto getDtoFromTvBox(TvBox tvBox) {
        ModelMapper modelMapper = new ModelMapper();

        TvBoxResponseDtoImpl tvBoxResponseDto = new TvBoxResponseDtoImpl();

        modelMapper.addMappings(new PropertyMap<TvBox, TvBoxResponseDtoImpl>() {
            protected void configure() {
                map().setBrandName(source.getBrandName().getBrandName());
            }
        });

        modelMapper.addMappings(new PropertyMap<TvBox, TvBoxResponseDtoImpl>() {
            protected void configure() {
                map().setColorName(source.getColorName().getColorName());
            }
        });

        modelMapper.map(tvBox, tvBoxResponseDto);

        return tvBoxResponseDto;
    }
}