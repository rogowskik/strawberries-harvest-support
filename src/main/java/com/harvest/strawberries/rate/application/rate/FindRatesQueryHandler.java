package com.harvest.strawberries.rate.application.rate;

import com.harvest.strawberries.infrastructure.query.QueryHandler;
import com.harvest.strawberries.rate.api.FindRatesQuery;
import com.harvest.strawberries.rate.api.RateView;
import com.harvest.strawberries.rate.domain.rate.RateRepository;
import com.harvest.strawberries.rate.domain.rate.RateToRateDtoMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@AllArgsConstructor
@Service
public class FindRatesQueryHandler implements QueryHandler<FindRatesQuery, List<RateView>> {

    private final RateRepository rateRepository;

    @Override
    public List<RateView> handle(FindRatesQuery query) {
            return StreamSupport.stream(rateRepository.findAll().spliterator(), true)
                    .collect(Collectors.toList())
                    .stream()
                    .map(RateToRateDtoMapper::rate)
                    .collect(Collectors.toList());
    }
}
