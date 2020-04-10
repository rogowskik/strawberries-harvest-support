package com.harvest.strawberries.rate.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
public class CreateRateDto {

    private LocalDate date;
    private int sorted;
    private int unsorted;
    private int cropped;
    private int kg;

}