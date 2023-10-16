package org.example.assembler.leave;

import org.example.domain.leave.entity.valueobject.Applicant;
import org.example.types.leave.ApplicantDTO;

/**
 * @author
 */
public class ApplicantAssembler {
    public static ApplicantDTO toDTO(Applicant applicant){
        ApplicantDTO dto = new ApplicantDTO();
        dto.setPersonId(applicant.getPersonId());
        dto.setPersonName(applicant.getPersonName());
        return dto;
    }

    public static Applicant toDO(ApplicantDTO dto){
        Applicant applicant = new Applicant();
        applicant.setPersonId(dto.getPersonId());
        applicant.setPersonName(dto.getPersonName());
        return applicant;
    }
}
