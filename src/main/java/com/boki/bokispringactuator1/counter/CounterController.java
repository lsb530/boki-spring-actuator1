package com.boki.bokispringactuator1.counter;

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

    @GetMapping("/req")
    public String req() {
//        myHttpRequestManager.increase();

        myManager.increase(); // filter, interceptor, aop
        return "ok";
    }

}
