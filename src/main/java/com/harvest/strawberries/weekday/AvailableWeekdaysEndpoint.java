package com.harvest.strawberries.weekday;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("rest/api/day-of-week")
public class AvailableWeekdaysEndpoint {

    private WeekdayResolver weekdayResolver;

    @GetMapping
    public List<CustomDayOfWeek> findAll() {
        return weekdayResolver.resolveDateRange();
    }
}
