package org.example.infrastructure.person.converter;

import org.example.domain.person.entity.Person;
import org.example.infrastructure.person.repository.po.PersonPo;
import org.example.shared.person.enums.PersonStatus;
import org.example.shared.person.enums.PersonType;
import org.springframework.stereotype.Service;

/**
 * @author sherry
 */
@Service
public class PersonFactory {
    public PersonPo createPersonPo(Person person){
        PersonPo personPo = new PersonPo();
        personPo.setId(person.getId());
        personPo.setPersonName(person.getPersonName());
        personPo.setRoleLevel(person.getRoleLevel());
        personPo.setPersonType(person.getPersonType().name());
        personPo.setStatus(person.getStatus().name());
        personPo.setCreateTime(person.getCreateTime());
        personPo.setLastModifyTime(person.getLastModifyTime());
        personPo.setDeleteTime(person.getDeleteTime());
        return personPo;
    }

    public Person createPerson(PersonPo po){
        Person person = new Person();
        person.setId(po.getId());
        person.setPersonType(PersonType.fromName(po.getPersonType()));
        person.setRoleLevel(po.getRoleLevel());
        person.setPersonName(po.getPersonName());
        person.setStatus(PersonStatus.fromName(po.getStatus()));
        person.setCreateTime(po.getCreateTime());
        person.setLastModifyTime(po.getLastModifyTime());
        person.setDeleteTime(po.getDeleteTime());
        return person;
    }

}
