package com.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by laiwenqiang on 2017/5/25.
 */
@Controller
@RequestMapping("/hello")
public class TestController {
    private static final String template = "Hello World! ";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    Message sayFuck(
            @RequestParam(value = "name", required = false, defaultValue = "Stranger") String name) {
        return new Message(counter.incrementAndGet(),
                String.format(template, name));
    }
}
