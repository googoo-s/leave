package org.example.assembler.leave;

import org.example.domain.leave.entity.ApprovalInfo;
import org.example.domain.leave.entity.Leave;
import org.example.types.leave.ApprovalInfoDto;
import org.example.types.leave.LeaveDto;
import org.example.util.DateUtil;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author
 */
public class LeaveAssembler {

    public static LeaveDto toDTO(Leave leave){
        LeaveDto dto = new LeaveDto();
        dto.setLeaveId(leave.getId());
        dto.setLeaveType(leave.getType().toString());
        dto.setStatus(leave.getStatus().toString());
        dto.setStartTime(DateUtil.formatDate(leave.getStartTime()));
        dto.setEndTime(DateUtil.formatDate(leave.getEndTime()));
        dto.setCurrentApprovalInfoDto(ApprovalInfoAssembler.toDTO(leave.getCurrentApprovalInfo()));
        List<ApprovalInfoDto> historyApprovalInfoDtoList = leave.getHistoryApprovalInfos()
                .stream()
                .map(historyApprovalInfo -> ApprovalInfoAssembler.toDTO(leave.getCurrentApprovalInfo()))
                .collect(Collectors.toList());
        dto.setHistoryApprovalInfoDtoList(historyApprovalInfoDtoList);
        dto.setDuration(leave.getDuration());
        return dto;
    }

    public static Leave toDO(LeaveDto dto){
        Leave leave = new Leave();
        leave.setId(dto.getLeaveId());
        leave.setApplicant(ApplicantAssembler.toDO(dto.getApplicantDto()));
        leave.setApprover(ApproverAssembler.toDO(dto.getApproverDto()));
        leave.setCurrentApprovalInfo(ApprovalInfoAssembler.toDO(dto.getCurrentApprovalInfoDto()));
        List<ApprovalInfo> historyApprovalInfoDTOList = dto.getHistoryApprovalInfoDtoList()
                .stream()
                .map(historyApprovalInfoDto -> ApprovalInfoAssembler.toDO(historyApprovalInfoDto))
                .collect(Collectors.toList());
        leave.setHistoryApprovalInfos(historyApprovalInfoDTOList);
        return leave;
    }

    public static Leave toDO(LeaveDto dto){
        Leave leave = new Leave();
        leave.setId(dto.getLeaveId());
        leave.setApplicant(ApplicantAssembler.toDO(dto.getApplicantDto()));
        leave.setApprover(ApproverAssembler.toDO(dto.getApproverDto()));
        leave.setCurrentApprovalInfo(ApprovalInfoAssembler.toDO(dto.getCurrentApprovalInfoDto()));
        List<ApprovalInfo> historyApprovalInfoDTOList = dto.getHistoryApprovalInfoDtoList()
                .stream()
                .map(historyApprovalInfoDto -> ApprovalInfoAssembler.toDO(historyApprovalInfoDto))
                .collect(Collectors.toList());
        leave.setHistoryApprovalInfos(historyApprovalInfoDTOList);
        return leave;
    }
}
