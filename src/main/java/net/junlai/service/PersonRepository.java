package net.junlai.service;

import net.junlai.domain.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PersonRepository extends CrudRepository<Person, Long> {

}
