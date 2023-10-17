package org.example.types.leave;

import lombok.Data;

/**
 * @author
 */
@Data
public class ApprovalInfoDto {


    private String approvalInfoId;

    private ApproverDto approverDto;

    private String msg;

    private long time;
}
