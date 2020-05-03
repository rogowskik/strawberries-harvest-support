package com.harvest.strawberries.reports.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

@AllArgsConstructor(staticName = "of")
@Getter
public class HarvestReportInformation {
    private String name;
    private String json;
}
