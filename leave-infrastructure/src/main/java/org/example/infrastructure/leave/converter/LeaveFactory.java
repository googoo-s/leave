package org.example.infrastructure.leave.converter;

import org.example.domain.leave.entity.ApprovalInfo;
import org.example.domain.leave.entity.Leave;
import org.example.domain.leave.entity.valueobject.Applicant;
import org.example.domain.leave.entity.valueobject.Approver;
import org.example.infrastructure.leave.repository.po.ApprovalInfoPo;
import org.example.infrastructure.leave.repository.po.LeavePo;
import org.example.shared.leave.enums.ApprovalType;
import org.example.shared.leave.enums.Status;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author sherry
 */
@Service
public class LeaveFactory {

    public LeavePo leavePoFromDo(Leave leave) {
        LeavePo leavePo = new LeavePo();
        leavePo.setId(leave.getId());
        leavePo.setCreateTime(leave.getCreateTime());
        leavePo.setLastModifyTime(leave.getLastModifyTime());
        leavePo.setDeleteTime(leave.getDeleteTime());
        leavePo.setApplicantId(leave.getApplicant().getPersonId());
        leavePo.setApplicantName(leave.getApplicant().getPersonName());
        leavePo.setApproverId(Optional.ofNullable(leave.getApprover()).map(Approver::getPersonId).orElse(null));
        leavePo.setApproverName(Optional.ofNullable(leave.getApprover()).map(Approver::getPersonName).orElse(null));
        leavePo.setContent(leave.getContent());
        leavePo.setStartTime(leave.getStartTime());
        leavePo.setStatus(leave.getStatus().name());
        leavePo.setMaxAgreeCount(leave.getMaxAgreeCount());
        return leavePo;
    }



    public Leave leaveDoFromPo(LeavePo leavePo, List<ApprovalInfoPo> historyApprovalInfoPos) {
        Applicant applicant = new Applicant(leavePo.getApplicantId(), leavePo.getApplicantName());
        Approver approver = new Approver(leavePo.getApproverId(), leavePo.getApproverName());
        Leave leave = new Leave(applicant, approver, leavePo.getContent(), Status.fromName(leavePo.getStatus()), leavePo.getStartTime(), leavePo.getEndTime(), leavePo.getMaxAgreeCount(), approvalInfoDosFromPos(historyApprovalInfoPos));
        leave.setId(leavePo.getId());
        leave.setCreateTime(leavePo.getCreateTime());
        leave.setLastModifyTime(leavePo.getLastModifyTime());
        leave.setDeleteTime(leavePo.getDeleteTime());
        return leave;
    }


    public ApprovalInfoPo approvalInfoPoFromDo(LeavePo leavePo, ApprovalInfo approvalInfo) {
        ApprovalInfoPo po = new ApprovalInfoPo();
        po.setId(approvalInfo.getId());
        po.setCreateTime(approvalInfo.getCreateTime());
        po.setLastModifyTime(approvalInfo.getLastModifyTime());
        po.setDeleteTime(approvalInfo.getDeleteTime());
        po.setLeaveId(leavePo.getId());
        po.setSeq(approvalInfo.getSeq());
        po.setApproverId(approvalInfo.getApprover().getPersonId());
        po.setApproverName(approvalInfo.getApprover().getPersonName());
        po.setApprovalType(approvalInfo.getApprovalType().name());
        po.setMsg(approvalInfo.getMsg());
        po.setApproveTime(approvalInfo.getApproveTime());
        return po;
    }

    public  ApprovalInfo approvalInfoDoFromPo(ApprovalInfoPo approvalInfoPo) {
        Approver approver = null;
        if (Objects.nonNull(approvalInfoPo.getApproverId()) && Objects.nonNull(approvalInfoPo.getApproverName())) {
            approver = new Approver(approvalInfoPo.getApproverId(), approvalInfoPo.getApproverName());
        }
        ApprovalInfo approvalInfo = new ApprovalInfo(approvalInfoPo.getSeq(), approver,
                ApprovalType.fromName(approvalInfoPo.getApprovalType()), approvalInfoPo.getMsg(), approvalInfoPo.getApproveTime());
        approvalInfo.setId(approvalInfoPo.getId());
        approvalInfo.setCreateTime(approvalInfoPo.getCreateTime());
        approvalInfo.setLastModifyTime(approvalInfoPo.getLastModifyTime());
        approvalInfo.setDeleteTime(approvalInfoPo.getDeleteTime());
        return approvalInfo;
    }

    public List<ApprovalInfo> approvalInfoDosFromPos(List<ApprovalInfoPo> approvalInfoPoList) {
        if (CollectionUtils.isEmpty(approvalInfoPoList)) {
            return null;
        }
        return approvalInfoPoList.stream()
                .map(this::approvalInfoDoFromPo)
                .collect(Collectors.toList());
    }
}
