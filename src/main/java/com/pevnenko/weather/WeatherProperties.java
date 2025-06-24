package com.pevnenko.weather;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "weather")
public class WeatherProperties {
    private String apiKey;
}
