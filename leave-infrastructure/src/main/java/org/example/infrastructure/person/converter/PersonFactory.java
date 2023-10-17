package org.example.infrastructure.person.converter;

import org.example.domain.person.entity.Person;
import org.example.domain.person.entity.valueobject.Address;
import org.example.infrastructure.person.repository.po.PersonPo;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author sherry
 */
@Service
public class PersonFactory {
    public PersonPo personPoFromDo(Person person){
        PersonPo personPo = new PersonPo();
        personPo.setId(person.getId());
        personPo.setCreateTime(person.getCreateTime());
        personPo.setLastModifyTime(person.getLastModifyTime());
        personPo.setDeleteTime(person.getDeleteTime());
        personPo.setPersonName(person.getPersonName());
        personPo.setLeaderId(person.getLeaderId());
        personPo.setProvince(Optional.ofNullable(person.getAddress()).map(Address::getProvince).orElse(null));
        personPo.setCity(Optional.ofNullable(person.getAddress()).map(Address::getCity).orElse(null));
        personPo.setExactAddress(Optional.ofNullable(person.getAddress()).map(Address::getExactAddress).orElse(null));
        return personPo;
    }

    public Person personDoFromPo(PersonPo po){
        Address address = Address.builder()
                .province(po.getProvince())
                .city(po.getCity())
                .exactAddress(po.getExactAddress())
                .build();
        Person person = new Person(po.getLeaderId(),po.getPersonName(),address);
        person.setCreateTime(po.getCreateTime());
        person.setLastModifyTime(po.getLastModifyTime());
        person.setDeleteTime(po.getDeleteTime());
        return person;
    }

}
