package com.harvest.strawberries.rate.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
@Getter
@Setter
public class CreateRateDto {

    private String dayOfWeek;
    private int sorted;
    private int unsorted;
    private int cropped;
    private int kg;

}