package com.example.truskawki.rate;

import com.example.truskawki.rate.create.CreateRateDto;
import com.example.truskawki.rate.create.Rate;
import com.example.truskawki.rate.create.RateRespository;
import com.example.truskawki.rate.exception.NotFoundException;
import com.example.truskawki.rate.find.RateDto;
import com.example.truskawki.rate.mapper.RateToRateDtoMapper;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@AllArgsConstructor
public class RateService {

    private RateRespository rateRespository;

    public void saveOrUpdate(CreateRateDto rateDto) {
        Rate rate = Optional.ofNullable(rateRespository.findByDate(rateDto.getDate())).orElse(new Rate());
        rate.setCropped(rateDto.getCropped());
        rate.setSorted(rateDto.getSorted());
        rate.setUnsorted(rateDto.getUnsorted());
        rate.setKg(rateDto.getKg());
        rateRespository.save(rate);
    }

    public List<RateDto> findAll() {
        return StreamSupport.stream(rateRespository.findAll().spliterator(), false)
                .collect(Collectors.toList())
                .stream()
                .map(RateToRateDtoMapper::rate)
                .collect(Collectors.toList());
    }

    public RateDto findById(String id) {
       return rateRespository.findById(id)
               .map(RateToRateDtoMapper::rate)
               .orElseThrow(() -> new NotFoundException("Rate with given was not found"));
    }

}