package com.boki.bokispringactuator1.metric;

import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.binder.MeterBinder;
import lombok.NonNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyStockMeterBinderConfig {
    @Bean
    public MeterBinder myStockMeterBinder(MyStockManager myStockManager) {
        return new MeterBinder() {
            @Override
            public void bindTo(@NonNull MeterRegistry registry) {
                Gauge.builder("my.stock", myStockManager, MyStockManager::getStockCount).register(registry);
            }
        };
    }
}
