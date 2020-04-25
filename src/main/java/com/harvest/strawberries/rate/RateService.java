package com.harvest.strawberries.rate;

import com.harvest.strawberries.rate.create.*;
import com.harvest.strawberries.rate.mapper.RateToRateDtoMapper;
import com.harvest.strawberries.rate.exception.CurrentExchangeRateNotFoundException;
import com.harvest.strawberries.rate.find.RateDto;
import com.harvest.strawberries.weekday.WeekdayMapper;
import com.harvest.strawberries.weekday.CustomDayOfWeek;
import com.harvest.strawberries.weekday.Weekday;
import com.harvest.strawberries.weekday.WeekdayResolver;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@AllArgsConstructor
public class RateService {

    private RateRepository rateRepository;

    private WeekdayResolver weekdayResolver;

    public void saveOrUpdate(CreateRateDto rateDto) {
        Weekday weekday = WeekdayMapper.valueOf(rateDto.getDayOfWeek().toUpperCase()).getWeekday();
        CustomDayOfWeek customDayOfWeek = weekdayResolver.findByWeekday(weekday);
        Rate rate = rateRepository
                .findByDateAndAndWeekday(customDayOfWeek.getDate(), customDayOfWeek.getDayOfWeek()).orElse(new Rate());
        rate.setBasketCropped(rateDto.getCropped());
        rate.setBasketSorted(rateDto.getSorted());
        rate.setBasketUnsorted(rateDto.getUnsorted());
        rate.setDate(customDayOfWeek.getDate());
        rate.setKg(rateDto.getKg());
        rate.setWeekday(weekday);
        rateRepository.save(rate);
    }

    public List<RateDto> findAll() {
        return StreamSupport.stream(rateRepository.findAll().spliterator(), true)
                .collect(Collectors.toList())
                .stream()
                .map(RateToRateDtoMapper::rate)
                .collect(Collectors.toList());
    }

    public RateDto findById(String id) {
       return rateRepository.findById(id)
               .map(RateToRateDtoMapper::rate)
               .orElseThrow(() -> new CurrentExchangeRateNotFoundException("Rate with given id was not found"));
    }

}