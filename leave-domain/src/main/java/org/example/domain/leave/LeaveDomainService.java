package org.example.domain.leave;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;
import org.example.domain.leave.entity.Leave;
import org.example.domain.leave.entity.valueobject.Applicant;
import org.example.domain.person.entity.Person;
import org.example.shared.leave.enums.ApprovalType;
import org.example.domain.leave.entity.valueobject.Approver;
import org.example.domain.leave.event.LeaveEvent;
import org.example.domain.leave.event.LeaveEventPublisher;
import org.example.domain.leave.repository.LeaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author sherry
 */
@Service
@Slf4j
public class LeaveDomainService {

    @Autowired
    LeaveEventPublisher eventPublisher;
    @Autowired
    LeaveRepository leaveRepository;


    @Transactional(rollbackFor = Exception.class)
    public void createLeave(Applicant applicant, Approver approver, String content, LocalDate startTime, LocalDate endTime, int maxAgreeCount) {
        Leave leave = new Leave(applicant, approver, content, startTime, endTime, maxAgreeCount);
        leaveRepository.save(leave);
        LeaveEvent event = LeaveEvent.create(LeaveEvent.LeaveEventType.CREATE_EVENT, leave);
        eventPublisher.publish(event);
    }

    @Transactional(rollbackFor = Exception.class)
    public void submitApproval(Leave leave, Approver approver, Approver nextApprover, ApprovalType approvalType, String msg) {
        LeaveEvent event;
        if (ApprovalType.REJECT == approvalType) {
            leave.reject(approver, msg);
            event = LeaveEvent.create(LeaveEvent.LeaveEventType.REJECT_EVENT, leave);
        } else {
            leave.agree(approver, nextApprover, msg);
            event = LeaveEvent.create(LeaveEvent.LeaveEventType.APPROVED_EVENT, leave);
        }
        leaveRepository.save(leave);
        eventPublisher.publish(event);
    }


    public Leave getLeaveInfo(Integer leaveId) {
        return leaveRepository.findById(leaveId);
    }

    public List<Leave> queryLeaveInfosByApplicant(Integer applicantId) {
        return leaveRepository.queryByApplicantId(applicantId);
    }

    public List<Leave> queryLeaveInfosByApprover(Integer approverId) {
        return leaveRepository.queryByApproverId(approverId);
    }

}