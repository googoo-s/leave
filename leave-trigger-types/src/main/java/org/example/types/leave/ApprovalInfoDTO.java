package org.example.types.leave;

import lombok.Data;

/**
 * @author
 */
@Data
public class ApprovalInfoDTO {


    private String approvalInfoId;

    private ApproverDTO approverDTO;

    private String msg;

    private long time;
}
