package org.example.assembler.leave;

import org.example.domain.leave.entity.valueobject.Approver;
import org.example.types.leave.ApproverDTO;

/**
 * @author
 */
public class ApproverAssembler {
    public static ApproverDTO toDTO(Approver approver){
        ApproverDTO dto = new ApproverDTO();
        dto.setPersonId(approver.getPersonId());
        dto.setPersonName(approver.getPersonName());
        return dto;
    }

    public static Approver toDO(ApproverDTO dto){
        Approver approver = new Approver();
        approver.setPersonId(dto.getPersonId());
        approver.setPersonName(dto.getPersonName());
        return approver;
    }

}
