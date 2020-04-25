package com.harvest.strawberries.weekday;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WeekdayResolver {

    private static final Map<Integer, Weekday> DAY_OF_WEEK_TO_WEEKDAY;

    static {
        DAY_OF_WEEK_TO_WEEKDAY = Map.of(
                0, Weekday.SATURDAY,
                1, Weekday.SUNDAY,
                2, Weekday.MONDAY,
                3, Weekday.TUESDAY,
                4, Weekday.WEDNESDAY,
                5, Weekday.THURSDAY,
                6, Weekday.FRIDAY);
    }

    public List<CustomDayOfWeek> resolveDateRange() {
        final LocalDate startOfLastWeek = getStartingPointForLastWeek();
        List<CustomDayOfWeek> days = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            days.add(new CustomDayOfWeek(startOfLastWeek.plusDays(i + 1), DAY_OF_WEEK_TO_WEEKDAY.get(i)));
        }
        return days;
    }

    public CustomDayOfWeek findByWeekday(Weekday weekdayToFind) {
       return resolveDateRange().stream()
                .filter(x-> weekdayToFind.equals(x.getDayOfWeek()))
                .findFirst()
                .orElseThrow(WeekdayNotFound::new);
    }

    public LocalDate getStartingPointForLastWeek() {
        final LocalDate input = LocalDate.now();
        return input.minusWeeks(1)
                .with(DayOfWeek.FRIDAY);
    }

}
