package org.example.types.leave;

import lombok.Data;

/**
 * @author
 */
@Data
public class ApplicantDto {


    String personId;

    String personName;

    String leaderId;

    String applicantType;

    String roleLevel;
}