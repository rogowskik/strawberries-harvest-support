package com.harvest.strawberries.reports;

import com.harvest.strawberries.infrastructure.command.CommandBusDispatcher;
import com.harvest.strawberries.reports.api.ImportHarvestFileCommand;
import com.harvest.strawberries.reports.domain.exception.HarvestJsonProcessingException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("rest/api/harvest/report")
@RestController
@AllArgsConstructor
public class HarvestReportEndpoint {

    private CommandBusDispatcher commandBusDispatcher;

    @PostMapping
    public void importHarvest() {
        commandBusDispatcher.dispatch(new ImportHarvestFileCommand());
    }

    @ExceptionHandler(value = HarvestJsonProcessingException.class)
    public ResponseEntity<?> handle(HarvestJsonProcessingException ex) {
        return ResponseEntity
                .badRequest()
                .body(ex.getLocalizedMessage());
    }
}
