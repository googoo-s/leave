package org.example.domain.leave.entity.valueobject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author sherry
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Applicant {

    String personId;
    String personName;
    String personType;
}
