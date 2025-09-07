package com.vasl.srm_test.config;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "reqres.api")
@Setter
@Getter
public class UrlApiConfig {
    private String url;
    private String apiKeyValue;
}
