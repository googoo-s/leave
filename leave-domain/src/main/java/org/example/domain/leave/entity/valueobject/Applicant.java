package org.example.domain.leave.entity.valueobject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.shared.person.enums.PersonType;

/**
 * @author sherry
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Applicant {

    private String personId;
    private String personName;
    private PersonType personType;
}
