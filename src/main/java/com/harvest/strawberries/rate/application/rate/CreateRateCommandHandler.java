package com.harvest.strawberries.rate.application.rate;

import com.harvest.strawberries.rate.api.CreateRateCommand;
import com.harvest.strawberries.rate.domain.rate.Rate;
import com.harvest.strawberries.rate.domain.rate.RateRepository;
import com.harvest.strawberries.infrastructure.command.CommandHandler;
import com.harvest.strawberries.rate.domain.weekday.CustomDayOfWeekView;
import com.harvest.strawberries.rate.domain.weekday.Weekday;
import com.harvest.strawberries.rate.domain.weekday.WeekdayMapper;
import com.harvest.strawberries.rate.domain.weekday.WeekdayResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CreateRateCommandHandler implements CommandHandler<CreateRateCommand> {

    private final RateRepository rateRepository;
    private final WeekdayResolver weekdayResolver;

    @Override
    public void handle(CreateRateCommand command) {
        Weekday weekday = WeekdayMapper.valueOf(command.getDayOfWeek().toUpperCase()).getWeekday();
        CustomDayOfWeekView customDayOfWeekView = weekdayResolver.findByWeekday(weekday);
        Rate rate = rateRepository
                .findByDateAndAndWeekday(customDayOfWeekView.getDate(), customDayOfWeekView.getDayOfWeek()).orElse(new Rate());
        rate.setBasketCropped(command.getCropped());
        rate.setBasketSorted(command.getSorted());
        rate.setBasketUnsorted(command.getUnsorted());
        rate.setDate(customDayOfWeekView.getDate());
        rate.setKg(command.getKg());
        rate.setWeekday(weekday);
        rateRepository.save(rate);
    }
}
