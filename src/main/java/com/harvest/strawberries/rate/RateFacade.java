package com.harvest.strawberries.rate;

import com.harvest.strawberries.rate.create.CreateRateDto;
import com.harvest.strawberries.rate.mapper.RateToRateDtoMapper;
import com.harvest.strawberries.rate.create.Rate;
import com.harvest.strawberries.rate.create.RateRespository;
import com.harvest.strawberries.rate.exception.CurrentExchangeRateNotFoundException;
import com.harvest.strawberries.rate.find.RateDto;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@AllArgsConstructor
public class RateFacade {

    private RateRespository rateRespository;

    public void saveOrUpdate(CreateRateDto rateDto) {
        Rate rate = Optional.ofNullable(rateRespository.findByDate(rateDto.getDate())).orElse(new Rate());
        rate.setBasketCropped(rateDto.getCropped());
        rate.setBasketSorted(rateDto.getSorted());
        rate.setBasketUnsorted(rateDto.getUnsorted());
        rate.setKg(rateDto.getKg());
        rateRespository.save(rate);
    }

    public List<RateDto> findAll() {
        return StreamSupport.stream(rateRespository.findAll().spliterator(), true)
                .collect(Collectors.toList())
                .stream()
                .map(RateToRateDtoMapper::rate)
                .collect(Collectors.toList());
    }

    public RateDto findById(String id) {
       return rateRespository.findById(id)
               .map(RateToRateDtoMapper::rate)
               .orElseThrow(() -> new CurrentExchangeRateNotFoundException("Rate with given id was not found"));
    }

}