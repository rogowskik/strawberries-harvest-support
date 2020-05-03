package com.harvest.strawberries;

import com.harvest.strawberries.infrastructure.configuration.InfrastructureBeanConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import( InfrastructureBeanConfiguration.class)
public class StrawberriesHarvestApplication {

	public static void main(String[] args) {
		SpringApplication.run(StrawberriesHarvestApplication.class, args);
	}

}
