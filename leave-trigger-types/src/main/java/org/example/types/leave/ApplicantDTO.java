package org.example.types.leave;

import lombok.Data;

/**
 * @author
 */
@Data
public class ApplicantDTO {


    String personId;

    String personName;

    String leaderId;

    String applicantType;

    String roleLevel;
}