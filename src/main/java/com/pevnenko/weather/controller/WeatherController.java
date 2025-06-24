package com.pevnenko.weather.controller;

import com.pevnenko.weather.model.WeatherHistory;
import com.pevnenko.weather.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/weather")
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherService weatherService;

    @GetMapping("/{city}")
    public WeatherHistory getWeather(@PathVariable("city") String city) {
        return weatherService.getWeather(city);
    }

    @GetMapping("/history")
    public List<WeatherHistory> getHistory() {
        return weatherService.getHistory();
    }
}
