package org.example.domain.leave.entity;

import java.time.LocalDate;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Data;
import org.example.domain.leave.entity.valueobject.Applicant;
import org.example.domain.leave.entity.valueobject.Approver;
import org.example.domain.leave.entity.valueobject.LeaveType;
import org.example.domain.leave.entity.valueobject.Status;

/**
 * 请假单信息
 */
@Data
public class Leave {

    String id;
    Applicant applicant;
    Approver approver;
    LeaveType type;
    Status status;
    LocalDate startTime;
    LocalDate endTime;
    long duration;
    //审批领导的最大级别
    int leaderMaxLevel;
    ApprovalInfo currentApprovalInfo;
    List<ApprovalInfo> historyApprovalInfos;

    public long getDuration() {
        return endTime.getTime() - startTime.getTime();
    }

    public Leave addHistoryApprovalInfo(ApprovalInfo approvalInfo) {
        if (null == historyApprovalInfos) {
            historyApprovalInfos = new ArrayList<ApprovalInfo>();
        }
        this.historyApprovalInfos.add(approvalInfo);
        return this;
    }

    public Leave create() {
        this.setStatus(Status.APPROVING);
        this.setStartTime(LocalDate.now());
        return this;
    }

    public Leave agree(Approver nextApprover) {
        this.setStatus(Status.APPROVING);
        this.setApprover(nextApprover);
        return this;
    }

    public Leave reject(Approver approver) {
        this.setApprover(approver);
        this.setStatus(Status.REJECTED);
        this.setApprover(null);
        return this;
    }

    public Leave finish() {
        this.setApprover(null);
        this.setStatus(Status.APPROVED);
        this.setEndTime(LocalDate.now());
        this.setDuration(this.getStartTime().until(this.getEndTime()).getDays());
        return this;
    }
}
