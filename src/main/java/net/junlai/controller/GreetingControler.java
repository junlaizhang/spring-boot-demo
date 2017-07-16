package net.junlai.controller;

import net.junlai.domain.Greeting;
import net.junlai.service.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("greetings")
public class GreetingControler {
    private static final String template = "Hello, %s";

    @Autowired
    GreetingRepository greetingRepository;


    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable() Long id
    ) {
        if (greetingRepository.exists(id)) {
            greetingRepository.delete(id);
        }
    }


    @GetMapping("/{id}")
    public Greeting get(
            @PathVariable() Long id
    ) {
        return greetingRepository.findOne(id);
    }


    @GetMapping("")
    public Iterable<Greeting> findGreetings(
            @RequestParam(value = "to", required = false) String to
    ) {
        if (to == null) {
            return greetingRepository.findAll();
        } else {
            return greetingRepository.findByTo(to);
        }
    }

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
