package org.example.domain.person.repository;


import org.example.domain.person.entity.Person;

/**
 * @author sherry
 */
public interface PersonRepository {

    void insert(Person person);

    void updateById(Person person);

    Person findById(String id);

    PersonPO findLeaderByPersonId(String personId);

}