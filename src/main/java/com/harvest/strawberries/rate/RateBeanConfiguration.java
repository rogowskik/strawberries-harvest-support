package com.harvest.strawberries.rate;

import com.harvest.strawberries.rate.create.RateRespository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RateBeanConfiguration {

    @Bean
    public RateFacade createRateService(final RateRespository rateRespository) {
        return new RateFacade(rateRespository);
    }
}