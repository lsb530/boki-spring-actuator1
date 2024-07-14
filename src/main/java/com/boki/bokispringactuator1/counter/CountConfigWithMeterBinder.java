package com.boki.bokispringactuator1.counter;

import io.micrometer.core.instrument.FunctionCounter;
import io.micrometer.core.instrument.binder.MeterBinder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CountConfigWithMeterBinder {

    @Bean
    public MeterBinder myCounterWithMeterBinder(MyHttpRequestManagerWithoutMicrometer myManager) {
        return registry -> FunctionCounter
            .builder("my.function.counter2", myManager, MyHttpRequestManagerWithoutMicrometer::getCount)
            .register(registry);
    }
}
