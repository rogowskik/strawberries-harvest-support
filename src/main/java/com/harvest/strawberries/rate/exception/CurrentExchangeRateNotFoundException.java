package com.harvest.strawberries.rate.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CurrentExchangeRateNotFoundException extends RuntimeException {

    public CurrentExchangeRateNotFoundException(String message) {
        super(message);
    }
}
