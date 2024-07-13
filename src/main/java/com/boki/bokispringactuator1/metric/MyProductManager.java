package com.boki.bokispringactuator1.metric;

import org.springframework.stereotype.Component;

import java.util.function.Supplier;

@Component
public class MyProductManager implements Supplier<Number> {

    public long getProductCount() {
        return System.currentTimeMillis();
    }

    @Override
    public Number get() {
        return getProductCount();
    }
}
