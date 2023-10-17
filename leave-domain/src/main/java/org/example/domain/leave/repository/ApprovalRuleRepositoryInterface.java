package org.example.domain.leave.repository;


import org.example.shared.leave.enums.LeaveType;
import org.example.shared.person.enums.PersonType;

public interface ApprovalRuleRepositoryInterface {

    int getLeaderMaxLevel(PersonType personType, LeaveType leaveType, long duration);
}
