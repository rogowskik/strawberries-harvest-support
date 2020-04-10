package com.example.truskawki.rate.mapper;

import com.example.truskawki.rate.create.Rate;
import com.example.truskawki.rate.find.RateDto;

public class RateToRateDtoMapper {

    public static RateDto rate(Rate rate) {
        return RateDto.builder()
                .cropped(rate.getCropped())
                .unsorted(rate.getUnsorted())
                .sorted(rate.getSorted())
                .build();
    }
}
