package org.example.domain.rule.repository.facade;


import org.example.domain.rule.entity.ApprovalRule;

public interface ApprovalRuleRepositoryInterface {

    int getLeaderMaxLevel(ApprovalRule rule);
}
