package org.example.infrastructure.person.repository;

import ddd.leave.domain.person.repository.po.PersonPO;
import org.example.domain.person.entity.Person;
import org.example.domain.person.repository.PersonRepository;
import org.example.infrastructure.person.converter.PersonFactory;
import org.example.infrastructure.person.repository.mapper.PersonDao;
import org.example.infrastructure.person.repository.po.PersonPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author sherry
 */
@Repository
public class PersonRepositoryImpl implements PersonRepository {

    @Autowired
    private PersonDao personDao;

    @Autowired
    private PersonFactory personFactory;

    @Override
    public void insert(Person person) {
        PersonPo personPo = personFactory.createPersonPo(person);
        personDao.save(personPo);
    }

    @Override
    public void updateById(Person person) {
        PersonPo personPo = personFactory.createPersonPo(person);
        personDao.save(personPo);
    }

    @Override
    public Person findById(String id) {
        PersonPo personPo = personDao.findById(id).orElseThrow(() -> new RuntimeException("未找到用户"));
        return personFactory.createPerson(personPo);

    }

    @Override
    public Person findLeaderByPersonId(String personId) {
        return personDao.findLeaderByPersonId(personId);
    }

}