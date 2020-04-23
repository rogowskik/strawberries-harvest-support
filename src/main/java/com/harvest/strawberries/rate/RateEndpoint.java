package com.harvest.strawberries.rate;

import com.harvest.strawberries.rate.RateFacade;
import com.harvest.strawberries.rate.create.CreateRateDto;
import com.harvest.strawberries.rate.find.RateDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("rest/api/rate")
@AllArgsConstructor
@RestController
public class RateEndpoint {

    private RateFacade rateFacade;

    @PostMapping
    public void create(@RequestBody CreateRateDto rateDto) {
        rateFacade.saveOrUpdate(rateDto);
    }

    @GetMapping("{id}")
    public void findById(@PathVariable("id") String id) {
        rateFacade.findById(id);
    }

    @GetMapping
    public List<RateDto> findAll() {
        return rateFacade.findAll();
    }
}
