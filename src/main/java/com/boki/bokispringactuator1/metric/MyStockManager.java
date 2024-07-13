package com.boki.bokispringactuator1.metric;

import org.springframework.stereotype.Component;

@Component
public class MyStockManager {

    public long getStockCount() {
        return System.currentTimeMillis();
    }
}
