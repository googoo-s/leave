package org.example.infrastructure.rule.repository.mapper;

import ddd.leave.domain.rule.entity.ApprovalRule;
import ddd.leave.domain.rule.repository.po.ApprovalRulePO;
import org.example.infrastructure.rule.repository.po.ApprovalRulePO;
import org.example.shared.leave.enums.LeaveType;
import org.example.shared.person.enums.PersonType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author sherry
 */
public interface ApprovalRuleDao extends JpaRepository<ApprovalRulePO, String> {

    @Query(value = "select r from ApprovalRulePO r where r.applicantRoleId=?1 and r.leaveType=?2 and duration=?3")
    ApprovalRulePO findRule(String personType, String leaveType, long duration);
}
