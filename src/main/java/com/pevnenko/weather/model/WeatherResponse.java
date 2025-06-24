package com.pevnenko.weather.model;

import lombok.Data;

@Data
public class WeatherResponse {
    private String city;
    private String description;
    private double temperature;
}
