package org.example.infrastructure.leave.converter;

import com.alibaba.fastjson.JSON;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.example.domain.leave.entity.ApprovalInfo;
import org.example.domain.leave.entity.Leave;
import org.example.domain.leave.entity.valueobject.Applicant;
import org.example.domain.leave.entity.valueobject.Approver;
import org.example.domain.leave.event.LeaveEvent;
import org.example.infrastructure.leave.repository.po.ApprovalInfoPo;
import org.example.infrastructure.leave.repository.po.LeaveEventPo;
import org.example.infrastructure.leave.repository.po.LeavePo;
import org.example.shared.leave.enums.Status;
import org.springframework.stereotype.Service;

/**
 * @author sherry
 */
@Service
public class LeaveFactory {

    public LeavePo createLeavePo(Leave leave) {
        LeavePo leavePo = new LeavePo();
        leavePo.setId(UUID.randomUUID().toString());
        leavePo.setApplicantId(leave.getApplicant().getPersonId());
        leavePo.setApplicantName(leave.getApplicant().getPersonName());
        leavePo.setApproverId(leave.getApprover().getPersonId());
        leavePo.setApproverName(leave.getApprover().getPersonName());
        leavePo.setStartTime(leave.getStartTime());
        leavePo.setStatus(leave.getStatus().name());
        List<ApprovalInfoPo> historyApprovalInfoPoList = approvalInfoPoListFromDo(leave);
        return leavePo;
    }

    public Leave getLeave(LeavePo leavePo) {
        Leave leave = new Leave();
        Applicant applicant = Applicant.builder()
                .personId(leavePo.getApplicantId())
                .personName(leavePo.getApplicantName())
                .build();
        leave.setApplicant(applicant);
        Approver approver = Approver.builder()
                .personId(leavePo.getApproverId())
                .personName(leavePo.getApproverName())
                .build();
        leave.setApprover(approver);
        leave.setStartTime(leavePo.getStartTime());
        leave.setStatus(Status.fromName(leavePo.getStatus()));
        return leave;
    }

    public LeaveEventPo createLeaveEventPo(LeaveEvent leaveEvent){
        LeaveEventPo eventPo = new LeaveEventPo();
        eventPo.setLeaveEventType(leaveEvent.getLeaveEventType().name());
        eventPo.setSource(leaveEvent.getSource());
        eventPo.setTimestamp(leaveEvent.getTimestamp());
        eventPo.setData(JSON.toJSONString(leaveEvent.getData()));
        return eventPo;
    }

    private List<ApprovalInfoPo> approvalInfoPoListFromDo(Leave leave) {
        return leave.getHistoryApprovalInfos()
                .stream()
                .map(this::approvalInfoPoFromDo)
                .collect(Collectors.toList());
    }

    private ApprovalInfoPo approvalInfoPoFromDo(ApprovalInfo approvalInfo){
        ApprovalInfoPo po = new ApprovalInfoPo();
        po.setApproverId(approvalInfo.getApprover().getPersonId());
        po.setApproverLevel(approvalInfo.getApprover().getLevel());
        po.setApproverName(approvalInfo.getApprover().getPersonName());
        po.setApprovalInfoId(approvalInfo.getApprovalInfoId());
        po.setMsg(approvalInfo.getMsg());
        po.setTime(approvalInfo.getTime());
        return po;
    }

    private ApprovalInfo approvalInfoFromPo(ApprovalInfoPo approvalInfoPo){
        ApprovalInfo approvalInfo = new ApprovalInfo();
        approvalInfo.setApprovalInfoId(approvalInfoPo.getApprovalInfoId());
        Approver approver = Approver.builder()
                .personId(approvalInfoPo.getApproverId())
                .personName(approvalInfoPo.getApproverName())
                .level(approvalInfoPo.getApproverLevel())
                .build();
        approvalInfo.setApprover(approver);
        approvalInfo.setMsg(approvalInfoPo.getMsg());
        approvalInfo.setTime(approvalInfoPo.getTime());
        return approvalInfo;
    }

    private List<ApprovalInfo> getApprovalInfos(List<ApprovalInfoPo> approvalInfoPoList){
        return approvalInfoPoList.stream()
                .map(this::approvalInfoFromPo)
                .collect(Collectors.toList());
    }
}
