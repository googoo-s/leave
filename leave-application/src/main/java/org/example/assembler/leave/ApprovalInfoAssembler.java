package org.example.assembler.leave;

import org.example.domain.leave.entity.ApprovalInfo;
import org.example.types.leave.ApprovalInfoDto;

/**
 * @author
 */
public class ApprovalInfoAssembler {
    public static ApprovalInfo toDO(ApprovalInfoDto dto){
        ApprovalInfo approvalInfo = new ApprovalInfo();
        approvalInfo.setApprovalInfoId(dto.getApprovalInfoId());
        approvalInfo.setMsg(dto.getMsg());
        approvalInfo.setApprover(ApproverAssembler.toDO(dto.getApproverDto()));
        return approvalInfo;
    }

    public static ApprovalInfoDto toDTO(ApprovalInfo approvalInfo){
        ApprovalInfoDto dto = new ApprovalInfoDto();
        dto.setApprovalInfoId(approvalInfo.getApprovalInfoId());
        dto.setMsg(approvalInfo.getMsg());
        dto.setTime(approvalInfo.getTime());
        return dto;
    }
}
