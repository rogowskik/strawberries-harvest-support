package com.harvest.strawberries.reports.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.harvest.strawberries.reports.domain.HarvestReportInformation;
import com.harvest.strawberries.reports.domain.exception.HarvestJsonProcessingException;
import lombok.AllArgsConstructor;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor
@Service
public class HarvestReportJsonProcessor {

    private final ObjectMapper mapper;
    private final HarvestPickerRepository harvestPickerRepository;

    /**
     * Process incoming request
     * <p>Note</p> file format should be: "IMIE_NAZWISKO_dd.MM.yyyy_HH-mm-ss otherwise exception
     * will be throw and flawed file will be moved to errors
     * @param information harvest file report
     */
    public void process(HarvestReportInformation information) {
        String fileName = information.getName();
        String[] array = fileName.split("_");
        if(array.length != 4) {
            //move to error
            throw new HarvestJsonProcessingException("Wrong date time format: " + fileName);
        }
        String dateTimeformat = (fileName.split("_")[2] +"_" + fileName.split("_")[3]).replaceAll(".json", "");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy_HH-mm-ss");
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeformat, formatter);
        try {
            HarvestPicker harvestPicker = mapper.readValue(information.getJson(), HarvestPicker.class);
            harvestPicker.setDate(dateTime);
            harvestPickerRepository.save(harvestPicker);
        } catch (JsonProcessingException e) {
            throw new HarvestJsonProcessingException("JsonProcessingException" + e.getMessage());

        }

    }

}
