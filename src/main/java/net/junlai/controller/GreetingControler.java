package net.junlai.controller;

import net.junlai.domain.Greeting;
import net.junlai.service.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("greetings")
public class GreetingControler {

    private static final String template = "Hello, %s";
    private final AtomicInteger counter = new AtomicInteger();

    @Autowired
    GreetingRepository greetingRepository;

    @PostMapping("")
    public Greeting creatGreeting(
            @RequestParam(value = "to", defaultValue = "World") String to
    ) {
        Greeting greeting = new Greeting();
        greeting.setTo(to);
        greeting.setContent(String.format(template, to));
        return greetingRepository.save(greeting);
    }
}
