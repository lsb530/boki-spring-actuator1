package com.boki.bokispringactuator1.timer;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TimerConfig {

    @Bean
    public Timer myTimer(MeterRegistry meterRegistry) {
        return Timer.builder("my.timer")
            .register(meterRegistry);
    }
}
