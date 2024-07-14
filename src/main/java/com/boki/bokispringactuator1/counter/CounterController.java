package com.boki.bokispringactuator1.counter;

import io.micrometer.core.annotation.Counted;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/counter")
@RestController
public class CounterController {

    private final MyHttpRequestManager myHttpRequestManager;

    private final MyHttpRequestManagerWithoutMicrometer myManager;

    private final MeterRegistry meterRegistry;

    @GetMapping("/req")
    public String req() {
//        myHttpRequestManager.increase();

//        myManager.increase(); // filter, interceptor, aop

        // these codes to AOP
        /*Counter.builder("my.http.request")
            .tag("class", this.getClass().toString())
            .register(meterRegistry)
            .increment();
        */

        return "ok";
    }

    @Counted("my.counted.counter")
    @GetMapping("/counted")
    public String counted() {
        return "ok";
    }

}
