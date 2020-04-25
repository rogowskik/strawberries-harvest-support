package com.harvest.strawberries.reports;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class HarvestJsonProcessingException extends RuntimeException {

    public HarvestJsonProcessingException(String message) {
        super(message);
    }
}
