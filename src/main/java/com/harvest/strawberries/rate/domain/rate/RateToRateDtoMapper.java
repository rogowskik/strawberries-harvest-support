package com.harvest.strawberries.rate.domain.rate;

import com.harvest.strawberries.rate.api.RateView;
import com.harvest.strawberries.rate.domain.weekday.WeekdayMapper;
import lombok.experimental.UtilityClass;

@UtilityClass
public class RateToRateDtoMapper {

    public static RateView rate(Rate rate) {

        return RateView.builder()
                .date(rate.getDate())
                .cropped(rate.getBasketCropped())
                .unsorted(rate.getBasketUnsorted())
                .sorted(rate.getBasketSorted())
                .kg(rate.getKg())
                .weekday(WeekdayMapper.toDto(rate.getWeekday()))
                .build();
    }
}
