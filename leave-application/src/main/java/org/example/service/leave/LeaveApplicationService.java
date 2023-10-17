package org.example.service.leave;

import com.alibaba.fastjson.JSON;
import org.example.domain.leave.LeaveDomainService;
import org.example.domain.leave.entity.Leave;
import org.example.domain.leave.entity.valueobject.Applicant;
import org.example.domain.leave.entity.valueobject.Approver;
import org.example.domain.person.entity.Person;
import org.example.domain.person.service.PersonDomainService;
import org.example.shared.leave.enums.Status;
import org.example.types.leave.ro.CreateLeaveRo;
import org.example.types.leave.ro.SubmitApprovalRo;
import org.example.types.leave.vo.LeaveVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * @author sherry
 */
@Service
public class LeaveApplicationService {

    private static final int APPROVE_LEVEL_NUM = 2;

    @Autowired
    LeaveDomainService leaveDomainService;

    @Autowired
    PersonDomainService personDomainService;


    public void createLeaveInfo(CreateLeaveRo createLeaveRo) {

        Person applicantPerson = personDomainService.findById(createLeaveRo.getApplicantId());
        if (Objects.isNull(applicantPerson)) {
            throw new RuntimeException("用户不存在");
        }
        List<Person> leaderLine = personDomainService.getLeaderLine(applicantPerson, APPROVE_LEVEL_NUM);
        Applicant applicant = new Applicant(applicantPerson.getId(), applicantPerson.getPersonName());
        Approver approver = null;
        int maxAgreeCount = 0;
        if (!CollectionUtils.isEmpty(leaderLine)) {
            Person person = leaderLine.get(0);
            approver = new Approver(person.getId(), person.getPersonName());
            maxAgreeCount = leaderLine.size();
        }
        leaveDomainService.createLeave(applicant, approver, createLeaveRo.getContent(), createLeaveRo.getStartTime(), createLeaveRo.getEndTime(), maxAgreeCount);
    }


    public void submitApproval(Integer leaveId, SubmitApprovalRo submitApprovalRo) {
        Leave leave = leaveDomainService.getLeaveInfo(leaveId);
        if (Objects.isNull(leave)) {
            throw new RuntimeException("请假不存在");
        }
        if (Arrays.asList(Status.REJECTED, Status.APPROVED).contains(leave.getStatus())) {
            throw new RuntimeException("已经审核完成了");
        }
        Integer approvedNum = Optional.ofNullable(leave.getHistoryApprovalInfos()).map(List::size).orElse(0);
        if (approvedNum >= leave.getMaxAgreeCount()) {
            throw new RuntimeException("已经审核完成了");
        }


        Person approverPerson = personDomainService.findById(submitApprovalRo.getApproverId());
        if (Objects.isNull(approverPerson)) {
            throw new RuntimeException("用户不存在");
        }
        Approver approver = new Approver(approverPerson.getId(), approverPerson.getPersonName());
        Person newApproverPerson = personDomainService.findNextApprover(approverPerson, leave.getMaxAgreeCount() - approvedNum);
        Approver nextApprover = new Approver(newApproverPerson.getId(), newApproverPerson.getPersonName());
        leaveDomainService.submitApproval(leave, approver, nextApprover,submitApprovalRo.getApprovalType(),submitApprovalRo.getMsg());
    }

    public LeaveVo getLeaveInfo(Integer leaveId) {
        Leave leave = leaveDomainService.getLeaveInfo(leaveId);
        return JSON.parseObject(JSON.toJSONString(leave), LeaveVo.class);
    }

    public List<LeaveVo> queryLeaveInfosByApplicant(Integer applicantId) {
        List<Leave> leaves = leaveDomainService.queryLeaveInfosByApplicant(applicantId);
        return JSON.parseArray(JSON.toJSONString(leaves), LeaveVo.class);
    }

    public List<LeaveVo> queryLeaveInfosByApprover(Integer approverId) {
        List<Leave> leaves = leaveDomainService.queryLeaveInfosByApprover(approverId);
        return JSON.parseArray(JSON.toJSONString(leaves), LeaveVo.class);
    }
}
