package com.boki.bokispringactuator1.custom;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyLibraryInfoEndpointConfig {
    @Bean
    public MyLibraryInfoEndpoint myLibraryInfoEndpoint() {
        return new MyLibraryInfoEndpoint();
    }
}
