package org.example.service.leave;

import org.example.domain.leave.LeaveDomainService;
import org.example.domain.person.service.PersonDomainService;
import org.example.domain.rule.service.ApprovalRuleDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author sherry
 */
@Service
public class LeaveApplicationService {

    @Autowired
    LeaveDomainService leaveDomainService;

    @Autowired
    PersonDomainService personDomainService;

    @Autowired
    ApprovalRuleDomainService approvalRuleDomainService;


}
