package com.harvest.strawberries.rate.domain.exception;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@AllArgsConstructor
public class WeekdayNotFound extends RuntimeException {
}
