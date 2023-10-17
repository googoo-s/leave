package org.example.types.leave.ro;

import java.time.LocalDate;
import org.example.shared.leave.enums.LeaveType;
import org.example.shared.leave.enums.Status;
import org.example.types.leave.ApplicantDto;

/**
 * @author
 */
public class CreateLeaveRo {

    private ApplicantDto applicant;
    private LeaveType type;
    private Status status;
    private LocalDate startTime;
    private LocalDate endTime;
    //审批领导的最大级别
    private int leaderMaxLevel;
    private ApprovalInfo currentApprovalInfo;
    private List<ApprovalInfo> historyApprovalInfos;
}
