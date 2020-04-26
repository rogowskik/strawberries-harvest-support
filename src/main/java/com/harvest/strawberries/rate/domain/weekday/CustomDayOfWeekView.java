package com.harvest.strawberries.rate.domain.weekday;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class CustomDayOfWeekView {
    private LocalDate date;
    private Weekday dayOfWeek;
}