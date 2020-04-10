package com.example.truskawki.rate.create;

import com.example.truskawki.RateEndpoint;
import com.example.truskawki.rate.RateService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RateBeanConfiguration {

    @Bean
    public RateService createRateService(final RateRespository rateRespository) {
        return new RateService(rateRespository);
    }

//    @Bean
//    RateEndpoint rateEndpoint(final RateService rateService) {
//        return new RateEndpoint(rateService);
//    }
}