package com.harvest.strawberries.weekday;

import com.harvest.strawberries.weekday.Weekday;
import com.harvest.strawberries.weekday.WeekdayNotFound;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;


@AllArgsConstructor
@Getter
public enum WeekdayMapper {
    SUN(Weekday.SUNDAY),
    MON(Weekday.MONDAY),
    SAT(Weekday.SATURDAY),
    TU(Weekday.TUESDAY),
    WED(Weekday.WEDNESDAY),
    TH(Weekday.THURSDAY),
    FRI(Weekday.FRIDAY);
    private Weekday weekday;

    public static String toDto(Weekday weekday) {
        return Arrays.stream(Weekday.values())
                .filter(x -> x.equals(weekday))
                .findFirst()
                .orElseThrow(WeekdayNotFound::new)
                .name();
    }
}