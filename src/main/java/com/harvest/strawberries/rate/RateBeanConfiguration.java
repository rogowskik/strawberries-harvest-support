package com.harvest.strawberries.rate;

import com.harvest.strawberries.rate.domain.weekday.WeekdayResolver;
import com.harvest.strawberries.reports.domain.FileHarvestReportImporter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RateBeanConfiguration {

    @Bean
    public WeekdayResolver weekdayResolver() {
        return new WeekdayResolver();
    }


}