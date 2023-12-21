package com.jot.custommicrometermetrics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.micrometer.observation.ObservationRegistry;
import io.micrometer.observation.aop.ObservedAspect;

@SpringBootApplication
public class CustomMicrometerMetricsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomMicrometerMetricsApplication.class, args);
	}

	@Bean
	public ObservedAspect observedAspect(ObservationRegistry observationRegistry) {
		return new ObservedAspect(observationRegistry);
	}

}
