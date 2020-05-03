package com.harvest.strawberries.reports.domain;

import com.harvest.strawberries.reports.domain.exception.HarvestJsonProcessingException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Service
public class FileHarvestReportImporter implements HarvestReportImporter {

    public FileHarvestReportImporter(HarvestReportJsonProcessor processor) {
        this.processor = processor;
    }

    @Value("${harvest.files.location}")
    private String path;

    private HarvestReportJsonProcessor processor;

    @Override
    public void importHarvestResults() {
        try (Stream<Path> paths = Files.walk(Paths.get(path))) {
            paths.filter(Files::isRegularFile)
                    .forEach(x -> {
                        try {
                            String jsonContent = Files.readString(x.toAbsolutePath());
                            processor.process(HarvestReportInformation.of(x.getFileName().toString(), jsonContent));
                        } catch (IOException e) {
                            throw new HarvestJsonProcessingException("Error while reading strings from file " + e.getMessage());
                        }
                    });
        } catch (IOException e) {
            throw new HarvestJsonProcessingException("Error while reading content from file " + e.getMessage());

        }
    }
}
