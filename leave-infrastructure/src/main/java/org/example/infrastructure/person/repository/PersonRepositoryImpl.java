package org.example.infrastructure.person.repository;

import java.util.Objects;
import org.example.domain.person.entity.Person;
import org.example.domain.person.repository.PersonRepository;
import org.example.infrastructure.person.converter.PersonFactory;
import org.example.infrastructure.person.repository.mapper.PersonDao;
import org.example.infrastructure.person.repository.po.PersonPo;
import org.example.util.DateUtil;
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
    public void save(Person person) {
        PersonPo personPo = personFactory.personPoFromDo(person);
        personDao.save(personPo);
    }


    @Override
    public Person findById(Integer id) {
        PersonPo personPo = personDao.findById(id).orElse(null);
        if (Objects.isNull(personPo) || !DateUtil.DEFAULT_DATE_TIME.isEqual(personPo.getDeleteTime())) {
            return null;
        }
        return personFactory.personDoFromPo(personPo);

    }


}