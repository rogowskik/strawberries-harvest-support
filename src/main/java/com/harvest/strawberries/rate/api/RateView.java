package com.harvest.strawberries.rate.api;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class RateView {

    private LocalDate date;
    private String weekday;
    private int sorted;
    private int unsorted;
    private int cropped;
    private int kg;
}
