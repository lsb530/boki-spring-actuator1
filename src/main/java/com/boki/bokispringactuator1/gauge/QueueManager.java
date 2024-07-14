package com.boki.bokispringactuator1.gauge;

import org.springframework.stereotype.Service;

@Service
public class QueueManager {

    public long getQueueSize() {
        return System.currentTimeMillis();
    }
}
