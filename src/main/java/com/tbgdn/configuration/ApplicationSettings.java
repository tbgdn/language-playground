package com.tbgdn.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Setter
@Getter
@Component
@ConfigurationProperties(prefix = "languages")
public class ApplicationSettings {

    private Map<String, String> chapter03;
    private Map<String, String> chapter04;
}
