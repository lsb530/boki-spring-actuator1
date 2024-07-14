package com.boki.bokispringactuator1.tag;

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

    private final MyQueueManagerWithTags myQueueManagerWithTags;

    @GetMapping("/push")
    public String push() {
        myQueueManagerWithTags.push();
        return "ok";
    }

    @GetMapping("/pop")
    public String pop() {
        myQueueManagerWithTags.pop();
        return "ok";
    }
}
