package org.example.types.leave.vo;

import org.example.shared.leave.enums.ApprovalType;
import org.example.shared.leave.enums.Status;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author
 */
public class LeaveVo {

    private ApplicantDto applicant;
    private ApproverDto approver;
    private String content;
    private Status status;
    private LocalDate startTime;
    private LocalDate endTime;
    private int maxAgreeCount;

    private List<ApprovalInfoDto> historyApprovalInfos;

    public static class ApplicantDto {
        private Integer personId;
        private String personName;
    }

    public static class ApproverDto {
        private Integer personId;
        private String personName;
    }

    public static class ApprovalInfoDto {
        private int seq;
        private ApproverDto approver;
        private ApprovalType approvalType;
        private String msg;
        private LocalDateTime approveTime;
    }
}
