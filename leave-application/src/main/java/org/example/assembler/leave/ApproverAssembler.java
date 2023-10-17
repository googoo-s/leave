package org.example.assembler.leave;

import org.example.domain.leave.entity.valueobject.Approver;
import org.example.types.leave.ApproverDto;

/**
 * @author
 */
public class ApproverAssembler {
    public static ApproverDto toDTO(Approver approver){
        ApproverDto dto = new ApproverDto();
        dto.setPersonId(approver.getPersonId());
        dto.setPersonName(approver.getPersonName());
        return dto;
    }

    public static Approver toDO(ApproverDto dto){
        Approver approver = new Approver();
        approver.setPersonId(dto.getPersonId());
        approver.setPersonName(dto.getPersonName());
        return approver;
    }

}
