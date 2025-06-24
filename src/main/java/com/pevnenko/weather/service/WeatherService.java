package com.pevnenko.weather.service;

import com.pevnenko.weather.WeatherProperties;
import com.pevnenko.weather.model.WeatherHistory;
import com.pevnenko.weather.repository.WeatherHistoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Log4j2
@Slf4j
public class WeatherService {

    private final WeatherHistoryRepository historyRepository;
    private final WeatherProperties weatherProperties;
    private final RestTemplate restTemplate = new RestTemplate();

    public WeatherHistory getWeather(String city) {

        try {
            String url = String.format(
                    "https://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s&units=metric",
                    city, weatherProperties.getApiKey()
            );

            var response = restTemplate.getForObject(url, Map.class);
            String name = ((Map<String, Object>) response).get("name").toString();
            String description =
                    ((Map<String, Object>) ((List<Object>) response.get("weather")).get(0)).get("description")
                            .toString();
            double temp = Double.parseDouble(((Map<String, Object>) response.get("main")).get("temp").toString());

            WeatherHistory weatherHistory;
            if (historyRepository.existsByCity(city)) {
                weatherHistory = historyRepository.getByCity(name);
                weatherHistory.setCity(name);
                weatherHistory.setDescription(description);
                weatherHistory.setTemperature(temp);
                weatherHistory.setRequestedAt(LocalDateTime.now());
            } else {
                weatherHistory = new WeatherHistory();
                weatherHistory.setCity(name);
                weatherHistory.setDescription(description);
                weatherHistory.setTemperature(temp);
                weatherHistory.setRequestedAt(LocalDateTime.now());
            }
            historyRepository.save(weatherHistory);

            return weatherHistory;
        } catch (HttpClientErrorException exception) {
            log.error(exception.getMessage());
            return WeatherHistory.builder()
                    .id(-1L)
                    .city(city)
                    .temperature(-1)
                    .description("Некорректное название города")
                    .build();
        }
    }

    public List<WeatherHistory> getHistory() {
        return historyRepository.findAllByOrderByRequestedAtDesc();
    }
}
