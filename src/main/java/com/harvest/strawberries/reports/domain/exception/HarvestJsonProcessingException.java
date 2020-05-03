package com.harvest.strawberries.reports.domain.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class HarvestJsonProcessingException extends RuntimeException {

    public HarvestJsonProcessingException(String message) {
        super(message);
    }
}
