package com.example.isandstesttask.service.filter;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TvBoxSearchCriteria extends BaseSearchCriteria {
    private String category;
    private String technology;
}