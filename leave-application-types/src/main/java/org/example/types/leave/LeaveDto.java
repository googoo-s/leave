package org.example.types.leave;

import lombok.Data;

import java.util.List;

/**
 * @author
 */
@Data
public class LeaveDto {


    private String leaveId;

    private ApplicantDto applicantDto;

    private ApproverDto approverDto;

    private String leaveType;

    private ApprovalInfoDto currentApprovalInfoDto;

    private List<ApprovalInfoDto> historyApprovalInfoDtoList;

    private String startTime;

    private String endTime;

    private Long duration;

    private String status;

}
