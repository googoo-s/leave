package org.example.assembler.leave;

import org.example.domain.leave.entity.ApprovalInfo;
import org.example.domain.leave.entity.Leave;
import org.example.types.leave.ApprovalInfoDTO;
import org.example.types.leave.LeaveDTO;
import org.example.util.DateUtil;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author
 */
public class LeaveAssembler {

    public static LeaveDTO toDTO(Leave leave){
        LeaveDTO dto = new LeaveDTO();
        dto.setLeaveId(leave.getId());
        dto.setLeaveType(leave.getType().toString());
        dto.setStatus(leave.getStatus().toString());
        dto.setStartTime(DateUtil.formatDate(leave.getStartTime()));
        dto.setEndTime(DateUtil.formatDate(leave.getEndTime()));
        dto.setCurrentApprovalInfoDTO(ApprovalInfoAssembler.toDTO(leave.getCurrentApprovalInfo()));
        List<ApprovalInfoDTO> historyApprovalInfoDTOList = leave.getHistoryApprovalInfos()
                .stream()
                .map(historyApprovalInfo -> ApprovalInfoAssembler.toDTO(leave.getCurrentApprovalInfo()))
                .collect(Collectors.toList());
        dto.setHistoryApprovalInfoDTOList(historyApprovalInfoDTOList);
        dto.setDuration(leave.getDuration());
        return dto;
    }

    public static Leave toDO(LeaveDTO dto){
        Leave leave = new Leave();
        leave.setId(dto.getLeaveId());
        leave.setApplicant(ApplicantAssembler.toDO(dto.getApplicantDTO()));
        leave.setApprover(ApproverAssembler.toDO(dto.getApproverDTO()));
        leave.setCurrentApprovalInfo(ApprovalInfoAssembler.toDO(dto.getCurrentApprovalInfoDTO()));
        List<ApprovalInfo> historyApprovalInfoDTOList = dto.getHistoryApprovalInfoDTOList()
                .stream()
                .map(historyApprovalInfoDTO -> ApprovalInfoAssembler.toDO(historyApprovalInfoDTO))
                .collect(Collectors.toList());
        leave.setHistoryApprovalInfos(historyApprovalInfoDTOList);
        return leave;
    }
}
