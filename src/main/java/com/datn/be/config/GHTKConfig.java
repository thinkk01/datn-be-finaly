package com.datn.be.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
public class GHTKConfig {
    @Value("${ghtk.api.url}")
    private String apiUrl;

    @Value("${ghtk.api.token}")
    private String apiToken;

    public String getApiUrl() {
        return apiUrl;
    }

    public String getApiToken() {
        return apiToken;
    }
}
