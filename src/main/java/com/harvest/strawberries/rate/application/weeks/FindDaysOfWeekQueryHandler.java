package com.harvest.strawberries.rate.application.weeks;

import com.harvest.strawberries.infrastructure.query.QueryHandler;
import com.harvest.strawberries.rate.api.FindDaysOfWeekQuery;
import com.harvest.strawberries.rate.domain.weekday.CustomDayOfWeekView;
import com.harvest.strawberries.rate.domain.weekday.WeekdayResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class FindDaysOfWeekQueryHandler implements QueryHandler<FindDaysOfWeekQuery, List<CustomDayOfWeekView>> {

    private final WeekdayResolver weekdayResolver;

    @Override
    public List<CustomDayOfWeekView> handle(FindDaysOfWeekQuery query) {
        return weekdayResolver.resolveDateRange();
    }
}
