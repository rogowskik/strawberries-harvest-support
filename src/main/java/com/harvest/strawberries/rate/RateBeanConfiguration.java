package com.harvest.strawberries.rate;

import com.harvest.strawberries.rate.create.RateRepository;
import com.harvest.strawberries.reports.FileHarvestReportImporter;
import com.harvest.strawberries.weekday.WeekdayResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RateBeanConfiguration {

    @Bean
    public RateService createRateService(final RateRepository rateRepository, final WeekdayResolver weekdayResolver) {
        return new RateService(rateRepository, weekdayResolver);
    }

    @Bean
    public WeekdayResolver weekdayResolver() {
        return new WeekdayResolver();
    }

    @Bean
    public FileHarvestReportImporter fileHarvestReportImporter() {
        return new FileHarvestReportImporter();
    }
}