package com.harvest.strawberries.weekday;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@AllArgsConstructor
public class WeekdayNotFound extends RuntimeException {
}
