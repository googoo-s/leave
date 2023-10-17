package org.example.domain.leave.entity.valueobject;

import lombok.*;
import org.example.domain.person.entity.Person;

/**
 * @author sherry
 */
public class Approver {

    @Getter
    private Integer personId;
    @Getter
    private String personName;

    public Approver(Integer personId, String personName) {
        this.personId = personId;
        this.personName = personName;
    }


}
