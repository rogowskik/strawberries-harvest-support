package com.harvest.strawberries.rate.domain.rate;

import com.harvest.strawberries.rate.domain.weekday.Weekday;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface RateRepository extends CrudRepository<Rate, String> {

    Optional<Rate> findByDateAndAndWeekday(LocalDate date, Weekday weekday);

}