package org.example.domain.leave.entity;

import java.time.LocalDateTime;
import lombok.Data;
import org.example.shared.leave.enums.ApprovalType;
import org.example.domain.leave.entity.valueobject.Approver;

/**
 * @author sherry
 */
@Data
public class ApprovalInfo extends E {

    private String approvalInfoId;
    private Approver approver;
    private ApprovalType approvalType;
    private String msg;
    private LocalDateTime time;

}
