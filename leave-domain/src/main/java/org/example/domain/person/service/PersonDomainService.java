package org.example.domain.person.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import lombok.extern.slf4j.Slf4j;
import org.example.domain.person.entity.Person;
import org.example.domain.person.entity.valueobject.Address;
import org.example.domain.person.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
@Slf4j
public class PersonDomainService {

    @Autowired
    PersonRepository personRepository;


    public void create(String personName, Address address) {
        Person person = new Person(personName, address);
        personRepository.save(person);
    }


    public void changeLeader(Integer subordinateId, Integer leaderId) {

        Person subordinate = Optional.ofNullable(findById(subordinateId)).orElseThrow(() -> new RuntimeException("下属不存在"));
        Person leader = Optional.ofNullable(findById(leaderId)).orElseThrow(() -> new RuntimeException("领导不存在"));
        changeLeader(subordinate, leader);
    }


    private void changeLeader(Person subordinate, Person leader) {
        subordinate.changeLeader(leader.getLeaderId());
        personRepository.save(subordinate);
    }


    public Person findById(Integer personId) {
        return personRepository.findById(personId);
    }

    public Person findLeader(Person person) {
        if (Objects.isNull(person.getLeaderId())) {
            return null;
        }
        return personRepository.findById(person.getLeaderId());
    }

    public List<Person> getAllLeaderLine(Integer personId) {
        Person person = Optional.ofNullable(findById(personId)).orElseThrow(() -> new RuntimeException("用户不存在"));

        return getAllLeaderLine(person);
    }

    public List<Person> getAllLeaderLine(Person person) {
        ArrayList<Person> resultList = new ArrayList<>();
        Person itar = person;
        while (Objects.nonNull(person.getLeaderId())) {
            Person leader = findLeader(itar);
            itar = leader;
            resultList.add(leader);
        }
        return resultList;
    }

    public List<Person> getLeaderLine(Person person, int count) {
        ArrayList<Person> resultList = new ArrayList<>();
        Person itar = person;
        while (Objects.nonNull(person.getLeaderId()) && count > 0) {
            Person leader = findLeader(itar);
            itar = leader;
            resultList.add(leader);
            count--;
        }
        return resultList;
    }

    public Person findNextApprover(Person person, int approveLevelNum) {
        List<Person> leaderLine = getLeaderLine(person, approveLevelNum);
        if (CollectionUtils.isEmpty(leaderLine)) {
            return null;
        }
        return leaderLine.get(0);
    }
}