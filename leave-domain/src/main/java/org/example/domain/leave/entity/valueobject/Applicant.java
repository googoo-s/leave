package org.example.domain.leave.entity.valueobject;

import lombok.Getter;

/**
 * @author sherry
 */
@Getter
public class Applicant {

    private Integer personId;
    private String personName;

    public Applicant(Integer personId, String personName) {
        this.personId = personId;
        this.personName = personName;
    }
}
