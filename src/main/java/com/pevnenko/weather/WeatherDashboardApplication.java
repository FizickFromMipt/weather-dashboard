package com.pevnenko.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(WeatherProperties.class)
public class WeatherDashboardApplication {
    public static void main(String[] args) {
        SpringApplication.run(WeatherDashboardApplication.class, args);
    }
}