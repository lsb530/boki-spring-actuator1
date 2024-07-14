package com.boki.bokispringactuator1.gauge;

import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
public class GaugeConfig {

    private final QueueManager queueManager;

    private final MeterRegistry meterRegistry;

    @PostConstruct
    public void register() {
        Gauge
            .builder("my.queue.size", queueManager, QueueManager::getQueueSize)
            .register(meterRegistry);
    }
}
