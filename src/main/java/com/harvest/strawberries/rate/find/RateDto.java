package com.harvest.strawberries.rate.find;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class RateDto {

    private LocalDate date;
    private int sorted;
    private int unsorted;
    private int cropped;
    private int kg;
}
