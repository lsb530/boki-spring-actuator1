package com.boki.bokispringactuator1.counter;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MyHttpRequestManager {

    private final MeterRegistry meterRegistry;

    private Counter httpRequestCounter;

    @PostConstruct
    void init() {
        httpRequestCounter = Counter.builder("my.http.request")
            .register(meterRegistry);
    }

    public void increase() {
        httpRequestCounter.increment();
    }
}
