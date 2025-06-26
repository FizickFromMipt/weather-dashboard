package com.pevnenko.weather;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "translator")
public class TranslatorProperties {
    private String enUrl;
}
