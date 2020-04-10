package com.harvest.strawberries.rate.create;

import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;

public interface RateRespository extends CrudRepository<Rate, String> {

    Rate findByDate(LocalDate date);

}