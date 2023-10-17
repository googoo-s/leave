package org.example.domain.leave.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import org.example.common.domain.AggregateRoot;
import org.example.domain.leave.entity.valueobject.Applicant;
import org.example.domain.leave.entity.valueobject.Approver;
import org.example.shared.leave.enums.LeaveType;
import org.example.shared.leave.enums.Status;

/**
 * 请假单信息
 * @author sherry
 */
@Data
public class Leave implements AggregateRoot {

    private String id;
    private Applicant applicant;
    private Approver approver;
    private LeaveType type;
    private Status status;
    private LocalDate startTime;
    private LocalDate endTime;
    private long duration;
    //审批领导的最大级别
    private int leaderMaxLevel;
    private ApprovalInfo currentApprovalInfo;
    private List<ApprovalInfo> historyApprovalInfos;

    public long getDuration() {
        return startTime.until(endTime).getDays();
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
