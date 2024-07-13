package com.boki.bokispringactuator1.metric;

import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.binder.MeterBinder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyProductMeterBinderConfig {
    @Bean
    public MeterBinder myProductMeterBinder(MyProductManager myProductManager) {
        return registry -> Gauge
            .builder("my.product", myProductManager)
            .register(registry);
    }
}
