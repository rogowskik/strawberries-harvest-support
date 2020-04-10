package com.example.truskawki.rate.find;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class RateDto {
    private LocalDate day;
    private int sorted;
    private int unsorted;
    private int cropped;
    private int kg;
}
