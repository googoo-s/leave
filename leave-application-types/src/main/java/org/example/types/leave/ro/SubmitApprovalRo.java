package org.example.types.leave.ro;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.shared.leave.enums.ApprovalType;

/**
 * @author
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubmitApprovalRo {
    private Integer ApproverId;
    private ApprovalType approvalType;
    private String msg;
}
