package com.pevnenko.weather.repository;

import com.pevnenko.weather.model.WeatherHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WeatherHistoryRepository extends JpaRepository<WeatherHistory, Long> {
    List<WeatherHistory> findAllByOrderByRequestedAtDesc();

    boolean existsByCity(String city);

    WeatherHistory getByCity(String city);
}
