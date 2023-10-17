package org.example.domain.person.repository;


import org.example.domain.person.entity.Person;

/**
 * @author sherry
 */
public interface PersonRepository {

    void save(Person person);


    Person findById(Integer id);

}