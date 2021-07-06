package com.example.isandstesttask.service.filter.TvBox;

import com.example.isandstesttask.entity.dto.request.TvBoxFilterDto;
import com.example.isandstesttask.entity.dto.response.TvBoxResponseDto;
import com.example.isandstesttask.entity.product.TvBox;
import java.util.List;

public interface TvBoxSearchService {
    List<TvBox> filterTvBox(TvBoxSearchCriteria tvBoxSearchCriteria);

    List<TvBoxResponseDto> filterTvBox(TvBoxFilterDto tvBoxFilterDto);


}