package org.example.domain.leave.entity;

import lombok.Data;
import org.example.domain.leave.entity.valueobject.ApprovalType;
import org.example.domain.leave.entity.valueobject.Approver;

/**
 * @author sherry
 */
@Data
public class ApprovalInfo {

    String approvalInfoId;
    Approver approver;
    ApprovalType approvalType;
    String msg;
    long time;

}
