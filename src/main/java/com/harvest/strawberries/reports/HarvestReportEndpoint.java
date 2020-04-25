package com.harvest.strawberries.reports;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("rest/api/harvest/report")
@AllArgsConstructor
@RestController
public class HarvestReportEndpoint {

    private HarvestReportImporter fileHarvestReportImporter;

    @PostMapping
    public void importHarvest() {
        fileHarvestReportImporter.importHarvestResults();
    }

    @ExceptionHandler(value = HarvestJsonProcessingException.class)
    public ResponseEntity<?> handle(HarvestJsonProcessingException ex) {
        return ResponseEntity
                .badRequest()
                .body(ex.getLocalizedMessage());
    }
}
