package org.example.domain.person.service;

import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.example.domain.person.entity.Person;
import org.example.domain.person.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PersonDomainService {

    @Autowired
    PersonRepository personRepository;


    public void create(Person person) {
        person.init();
        personRepository.insert(person);
    }

    public void update(Person person) {
        if (Objects.isNull(person.getId())) {
            throw new RuntimeException("id不能为空");
        }
        person.markModify();
        personRepository.updateById(person);
    }

    public void deleteById(String personId) {
        Person person = personRepository.findById(personId);
        person.delete();
        personRepository.updateById(person);
    }

    public void addSubordinate(Person leader, Person subordinate) {
        leader.addSubordinate(subordinate);
    }

    /**
     * find leader with applicant, if leader level bigger then leaderMaxLevel return null, else return Approver from
     * leader;
     *
     * @param applicantId
     * @param leaderMaxLevel
     * @return
     */
    public Person findFirstApprover(String applicantId, int leaderMaxLevel) {
        PersonPO leaderPO = personRepository.findLeaderByPersonId(applicantId);
        if (leaderPO.getRoleLevel() > leaderMaxLevel) {
            return null;
        } else {
            return personFactory.createPerson(leaderPO);
        }
    }

    /**
     * find leader with current approver, if leader level bigger then leaderMaxLevel return null, else return Approver
     * from leader;
     *
     * @param currentApproverId
     * @param leaderMaxLevel
     * @return
     */
    public Person findNextApprover(String currentApproverId, int leaderMaxLevel) {
        PersonPO leaderPO = personRepository.findLeaderByPersonId(currentApproverId);
        if (leaderPO.getRoleLevel() > leaderMaxLevel) {
            return null;
        } else {
            return personFactory.createPerson(leaderPO);
        }
    }

}