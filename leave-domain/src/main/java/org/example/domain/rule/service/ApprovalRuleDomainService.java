package org.example.domain.rule.service;

import org.example.domain.rule.entity.ApprovalRule;
import org.example.domain.rule.repository.facade.ApprovalRuleRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApprovalRuleDomainService {

    @Autowired
    ApprovalRuleRepositoryInterface repositoryInterface;

    public int getLeaderMaxLevel(String personType, String leaveType, long duration) {
        ApprovalRule rule = new ApprovalRule();
        rule.setPersonType(personType);
        rule.setLeaveType(leaveType);
        rule.setDuration(duration);
        return repositoryInterface.getLeaderMaxLevel(rule);
    }
}
