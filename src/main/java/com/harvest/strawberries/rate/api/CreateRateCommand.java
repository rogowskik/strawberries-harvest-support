package com.harvest.strawberries.rate.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
@Getter
@Setter
public class CreateRateCommand {

    private String dayOfWeek;
    private int sorted;
    private int unsorted;
    private int cropped;
    private int kg;

}