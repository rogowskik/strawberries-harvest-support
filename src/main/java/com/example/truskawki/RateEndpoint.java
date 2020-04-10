package com.example.truskawki;

import com.example.truskawki.rate.RateService;
import com.example.truskawki.rate.create.CreateRateDto;
import com.example.truskawki.rate.find.RateDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("rest/api/rate")
@AllArgsConstructor
@RestController
public class RateEndpoint {

    private RateService rateService;

    @PostMapping
    public void create(@RequestBody CreateRateDto rateDto) {
        rateService.saveOrUpdate(rateDto);
    }

    @GetMapping("{id}")
    public void findById(@PathVariable("id") String id) {
        rateService.findById(id);
    }

    @GetMapping
    public List<RateDto> findAll() {
       return rateService.findAll();
    }
}
