package com.boki.bokispringactuator1.timer;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/timer")
@RestController
public class TimerController {

    @Qualifier("myTimer")
    private final Timer myTimer;

    private final MeterRegistry meterRegistry;

    @GetMapping("/timer")
    public String timer() {
        myTimer.record(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        return "ok";
    }

    @GetMapping("/timer2")
    public String timer2() throws InterruptedException {
        Timer.Sample sample = Timer.start(meterRegistry);

        // biz logic...
        Thread.sleep(2000);

        sample.stop(meterRegistry.timer("my.timer2"));

        return "ok";
    }
}
