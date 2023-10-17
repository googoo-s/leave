package org.example.service.person;

import java.text.ParseException;
import java.util.Objects;
import org.example.assembler.person.PersonAssembler;
import org.example.domain.person.entity.Person;
import org.example.domain.person.service.PersonDomainService;
import org.example.types.auth.PersonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author sherry
 */
@Service
public class PersonApplicationService {

    @Autowired
    PersonDomainService personDomainService;

    public void create(PersonDto personDto) throws ParseException {
        if (Objects.nonNull(personDto.getId())) {
            throw new RuntimeException("不能包含ID");
        }
        personDomainService.create(PersonAssembler.toDO(personDto));
    }

    public void update(PersonDto personDto) throws ParseException {
        personDomainService.update(PersonAssembler.toDO(personDto));
    }

    public void deleteById(String personId) {
        personDomainService.deleteById(personId);
    }

    public PersonDto findById(String personId) {
        return null;
    }

    public PersonDto findFirstApprover(String applicantId, int leaderMaxLevel) {
        Person firstApprover = personDomainService.findFirstApprover(applicantId, leaderMaxLevel);
        return PersonAssembler.toDTO(firstApprover);
    }
}
