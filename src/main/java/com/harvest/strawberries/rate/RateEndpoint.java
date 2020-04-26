package com.harvest.strawberries.rate;

import com.harvest.strawberries.infrastructure.command.CommandBusDispatcher;
import com.harvest.strawberries.infrastructure.query.QueryBusDispatcher;
import com.harvest.strawberries.rate.api.CreateRateCommand;
import com.harvest.strawberries.rate.api.FindDaysOfWeekQuery;
import com.harvest.strawberries.rate.api.FindRatesQuery;
import com.harvest.strawberries.rate.api.RateView;
import com.harvest.strawberries.rate.domain.weekday.CustomDayOfWeekView;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("rest/api/rate")
@RestController
@AllArgsConstructor
public class RateEndpoint {

    private CommandBusDispatcher commandBusDispatcher;
    private QueryBusDispatcher<FindRatesQuery, List<RateView>> queryBusDispatcher;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody CreateRateCommand createRateCommand) {
        commandBusDispatcher.dispatch(createRateCommand);
    }

    @GetMapping
    public List<RateView> findAll() {
        return queryBusDispatcher.dispatch(new FindRatesQuery());
    }

    @RestController
    @AllArgsConstructor
    @RequestMapping("rest/api/day-of-week")
    public static class AvailableWeekdaysEndpoint {

        private QueryBusDispatcher<FindDaysOfWeekQuery, List<CustomDayOfWeekView>> queryBusDispatcher;

        @GetMapping
        public List<CustomDayOfWeekView> findAll() {
            return queryBusDispatcher.dispatch(new FindDaysOfWeekQuery());
        }
    }
}
