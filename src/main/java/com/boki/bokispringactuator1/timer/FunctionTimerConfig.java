package com.boki.bokispringactuator1.timer;

import io.micrometer.core.instrument.FunctionTimer;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class FunctionTimerConfig {

    @Bean
    public FunctionTimer myFunctionTimer(
        MyTimerManager myTimerManager,
        MeterRegistry meterRegistry
    ) {
        return FunctionTimer
            .builder("my.timer4",
                myTimerManager,
                MyTimerManager::getCount,
                MyTimerManager::getTotalTime,
                TimeUnit.SECONDS
            )
            .register(meterRegistry);
    }
}
