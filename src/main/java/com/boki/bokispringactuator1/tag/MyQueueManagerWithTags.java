package com.boki.bokispringactuator1.tag;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MyQueueManagerWithTags {

    private final MeterRegistry meterRegistry;

    public void push() {
        Counter.builder("my.queue.counter")
            .tag("type", "push")
            .tag("class", this.getClass().toString())
            .register(meterRegistry)
            .increment();
    }

    public void pop() {
        Counter.builder("my.queue.counter")
            .tag("type", "pop")
            .tag("class", this.getClass().toString())
            .register(meterRegistry)
            .increment();
    }

}
