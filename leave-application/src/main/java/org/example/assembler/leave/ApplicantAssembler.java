package org.example.assembler.leave;

import org.example.domain.leave.entity.valueobject.Applicant;
import org.example.types.leave.ApplicantDto;

/**
 * @author
 */
public class ApplicantAssembler {
    public static ApplicantDto toDTO(Applicant applicant){
        ApplicantDto dto = new ApplicantDto();
        dto.setPersonId(applicant.getPersonId());
        dto.setPersonName(applicant.getPersonName());
        return dto;
    }

    public static Applicant toDO(ApplicantDto dto){
        Applicant applicant = new Applicant();
        applicant.setPersonId(dto.getPersonId());
        applicant.setPersonName(dto.getPersonName());
        return applicant;
    }
}
