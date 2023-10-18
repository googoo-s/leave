package org.example.types.leave.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.shared.leave.enums.ApprovalType;
import org.example.shared.leave.enums.Status;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author sherry
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeaveVo {

    private ApplicantDto applicant;
    private ApproverDto approver;
    private String content;
    private Status status;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate startTime;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate endTime;
    private int maxAgreeCount;

    private List<ApprovalInfoDto> historyApprovalInfos;

    @Builder
    @Data
    @AllArgsConstructor
    @NoArgsConstructor

    public static class ApplicantDto {
        private Integer personId;
        private String personName;
    }

    @Builder
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ApproverDto {
        private Integer personId;
        private String personName;
    }

    @Builder
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ApprovalInfoDto {
        private int seq;
        private ApproverDto approver;
        private ApprovalType approvalType;
        private String msg;
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
        private LocalDateTime approveTime;
    }
}
