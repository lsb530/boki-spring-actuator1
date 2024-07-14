package com.boki.bokispringactuator1.timer;

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
}
