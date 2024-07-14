package com.boki.bokispringactuator1.tag;

import io.micrometer.core.annotation.Counted;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/tag")
@RestController
public class TagController {

//    private final MyQueueManagerWithTags myQueueManagerWithTags;

    private final MeterRegistry meterRegistry;

    @Counted(value = "my.counted", extraTags = { "type1", "value1", "type2", "value2" })
    @GetMapping("/push")
    public String push() {
//        myQueueManagerWithTags.push();
        return "ok";
    }

    @Counted(value = "my.counted", extraTags = { "type3", "value3", "type4", "value4" })
    @GetMapping("/pop")
    public String pop() {
//        myQueueManagerWithTags.pop();
        return "ok";
    }

    @GetMapping("/test")
    public String test() {
        // metrics의 endpoint가 같아도 tag가 다르면 다른 인스턴스가 만들어진다
        // counter1: -1751949781, counter2: -1751949781 counter3: -1975241815, counter4: -1134301749
        Counter counter1 = Counter.builder("my.test")
            .tag("type", "push")
            .register(meterRegistry);

        Counter counter2 = Counter.builder("my.test")
            .tag("type", "push")
            .register(meterRegistry);

        Counter counter3 = Counter.builder("my.test")
            .tag("type", "push222")
            .register(meterRegistry);

        Counter counter4 = Counter.builder("my.test")
            .tag("type", "push333333")
            .register(meterRegistry);

        log.info("counter1: {}, counter2: {} counter3: {}, counter4: {}", counter1.hashCode(), counter2.hashCode(), counter3.hashCode(), counter4.hashCode());

        return "ok";
    }
}
