package com.harvest.strawberries.reports.application;

import com.harvest.strawberries.infrastructure.command.CommandHandler;
import com.harvest.strawberries.reports.domain.FileHarvestReportImporter;
import com.harvest.strawberries.reports.api.ImportHarvestFileCommand;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ImportHarvestFileCommandHandler implements CommandHandler<ImportHarvestFileCommand> {

    private FileHarvestReportImporter harvestReportImporter;

    @Override
    public void handle(ImportHarvestFileCommand command) {
        harvestReportImporter.importHarvestResults();
    }
}
