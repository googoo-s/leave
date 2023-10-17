package org.example.assembler.person;

import java.text.ParseException;
import org.example.domain.person.entity.Person;
import org.example.shared.person.enums.PersonStatus;
import org.example.shared.person.enums.PersonType;
import org.example.types.auth.PersonDto;
import org.example.util.DateUtil;

/**
 * @author
 */
public class PersonAssembler {
    public static PersonDto toDTO(Person person){
        PersonDto dto = new PersonDto();
        dto.setId(person.getId());
        dto.setPersonType(person.getPersonType().toString());
        dto.setPersonName(person.getPersonName());
        dto.setStatus(person.getStatus().toString());
        dto.setCreateTime(DateUtil.formatDateTime(person.getCreateTime()));
        dto.setLastModifyTime(DateUtil.formatDateTime(person.getLastModifyTime()));
        return dto;
    }

    public static Person toDO(PersonDto dto) throws ParseException {
        Person person = new Person();
        person.setId(dto.getId());
        person.setPersonType(PersonType.valueOf(dto.getPersonType()));
        person.setPersonName(dto.getPersonName());
        person.setStatus(PersonStatus.valueOf(dto.getStatus()));
        person.setCreateTime(DateUtil.parseDateTime(dto.getCreateTime()));
        person.setLastModifyTime(DateUtil.parseDateTime(dto.getLastModifyTime()));
        return person;
    }
}
