package com.harvest.strawberries;

import com.harvest.strawberries.rate.RateEndpoint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackageClasses = {RateEndpoint.class})
public class StrawberriesHarvestApplication {

	public static void main(String[] args) {
		SpringApplication.run(StrawberriesHarvestApplication.class, args);
	}

}
