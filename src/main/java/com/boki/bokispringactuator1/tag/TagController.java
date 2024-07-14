package com.boki.bokispringactuator1.tag;

import io.micrometer.core.annotation.Counted;
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
}
