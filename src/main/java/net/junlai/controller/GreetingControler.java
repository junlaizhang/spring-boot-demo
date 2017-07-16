package net.junlai.controller;

import net.junlai.domain.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("greeting")
public class GreetingControler {

    private static final String template = "Hello, %s, your age is %s!";
    private final AtomicInteger counter = new AtomicInteger();

    @RequestMapping("")
    public Greeting greeting(
            @RequestParam(value = "name", defaultValue = "World") String name,
            @RequestParam(value = "age", defaultValue = "18") Integer age

    ) {
        return new Greeting(
                counter.incrementAndGet(),
                String.format(template, name, age)
        );
    }
}
