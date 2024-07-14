package com.boki.bokispringactuator1.counter;

import io.micrometer.core.instrument.FunctionCounter;
import io.micrometer.core.instrument.MeterRegistry;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
public class MyFunctionCounterConfig {

    private final MyHttpRequestManagerWithoutMicrometer myManager;

    private final MeterRegistry meterRegistry;

    @PostConstruct
    void init() {
        FunctionCounter.builder("my.function.counter", myManager, MyHttpRequestManagerWithoutMicrometer::getCount)
            .register(meterRegistry);
    }
}
