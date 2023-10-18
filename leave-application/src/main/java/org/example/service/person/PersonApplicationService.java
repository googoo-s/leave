package org.example.service.person;

import org.example.domain.person.entity.Person;
import org.example.domain.person.entity.valueobject.Address;
import org.example.domain.person.service.PersonDomainService;
import org.example.types.person.ro.CreatePersonRo;
import org.example.types.person.vo.LeaderLineVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author sherry
 */
@Service
public class PersonApplicationService {

    @Autowired
    PersonDomainService personDomainService;

    public void create(CreatePersonRo createPersonRo) {
        personDomainService.create(createPersonRo.getPersonName(), Address.builder()
                .province(createPersonRo.getProvince())
                .city(createPersonRo.getCity())
                .exactAddress(createPersonRo.getExactAddress())
                .build());
    }

    public void changeLeader(Integer subordinateId, Integer leaderId) {
        personDomainService.changeLeader(subordinateId, leaderId);

    }


    public List<LeaderLineVo> getLeaderLine(Integer personId) {
        List<Person> allLeaderLine = personDomainService.getAllLeaderLine(personId);
        return allLeaderLine.stream().map(person ->
                LeaderLineVo.builder()
                        .id(person.getId())
                        .personName(person.getPersonName())
                        .leaderId(person.getLeaderId())
                        .province(Optional.ofNullable(person.getAddress()).map(Address::getProvince).orElse(null))
                        .city(Optional.of(person.getAddress()).map(Address::getProvince).orElse(null))
                        .exactAddress(Optional.of(person.getAddress()).map(Address::getExactAddress).orElse(null))
                        .build()
        ).collect(Collectors.toList());
    }
}
