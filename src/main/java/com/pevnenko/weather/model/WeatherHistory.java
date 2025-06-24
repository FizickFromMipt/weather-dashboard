package com.pevnenko.weather.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "history")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WeatherHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String city;
    private String description;
    private double temperature;
    private LocalDateTime requestedAt;
}
