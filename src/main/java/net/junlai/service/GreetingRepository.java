package net.junlai.service;

import net.junlai.domain.Greeting;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GreetingRepository extends CrudRepository<Greeting, Long> {
    List<Greeting> findByTo(String to);
}

