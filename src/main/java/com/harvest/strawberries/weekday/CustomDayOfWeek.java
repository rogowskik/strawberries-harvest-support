package com.harvest.strawberries.weekday;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class CustomDayOfWeek {
    private LocalDate date;
    private Weekday dayOfWeek;
}