package org.example.domain.leave.entity;

import lombok.Data;
import org.example.common.domain.Entity;
import org.example.shared.leave.enums.LeaveType;
import org.example.shared.person.enums.PersonType;

/**
 * @author sherry
 */
@Data
public class ApprovalRule extends Entity {

    private PersonType personType;
    private LeaveType leaveType;
    private long duration;
    private int maxLeaderLevel;

    public static ApprovalRule getByLeave(Leave leave){
        ApprovalRule rule = new ApprovalRule();
        rule.setPersonType(leave.getApplicant().getPersonType());
        rule.setLeaveType(leave.getType());
        rule.setDuration(leave.getDuration());
        return rule;
    }
}
