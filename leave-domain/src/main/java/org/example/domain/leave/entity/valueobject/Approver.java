package org.example.domain.leave.entity.valueobject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.domain.person.entity.Person;

/**
 * @author sherry
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Approver {

    private String personId;
    private String personName;
    private int level;

    public static Approver fromPerson(Person person) {
        Approver approver = new Approver();
        approver.setPersonId(person.getPersonId());
        approver.setPersonName(person.getPersonName());
        approver.setLevel(person.getRoleLevel());
        return approver;
    }

}
