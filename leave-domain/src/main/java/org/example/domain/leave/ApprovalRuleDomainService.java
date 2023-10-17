package org.example.domain.leave;

import org.example.domain.leave.entity.ApprovalRule;
import org.example.domain.leave.repository.ApprovalRuleRepositoryInterface;
import org.example.shared.leave.enums.LeaveType;
import org.example.shared.person.enums.PersonType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApprovalRuleDomainService {

    @Autowired
    ApprovalRuleRepositoryInterface repositoryInterface;

    public int getLeaderMaxLevel(PersonType personType, LeaveType leaveType, long duration) {
        ApprovalRule rule = new ApprovalRule();
        rule.setPersonType(personType);
        rule.setLeaveType(leaveType);
        rule.setDuration(duration);
        return repositoryInterface.getLeaderMaxLevel(rule);
    }
}
