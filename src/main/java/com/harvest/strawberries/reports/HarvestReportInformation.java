package com.harvest.strawberries.reports;

import lombok.AllArgsConstructor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

@AllArgsConstructor(staticName = "of")
public class HarvestReportInformation {
    private String name;
    private String json;
}
