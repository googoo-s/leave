package org.example.infrastructure.rule.repository;

import org.example.domain.leave.repository.ApprovalRuleRepositoryInterface;
import org.example.infrastructure.rule.repository.mapper.ApprovalRuleDao;
import org.example.infrastructure.rule.repository.po.ApprovalRulePO;
import org.example.shared.leave.enums.LeaveType;
import org.example.shared.person.enums.PersonType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ApprovalRuleRepositoryImpl implements ApprovalRuleRepositoryInterface {

    @Autowired
    ApprovalRuleDao ruleDao;

    @Override
    public int getLeaderMaxLevel(PersonType personType, LeaveType leaveType, long duration) {
        ApprovalRulePO rule = ruleDao.findRule(personType, leaveType, rule.getDuration());
        return rule.getMaxLeaderLevel();
    }
}
