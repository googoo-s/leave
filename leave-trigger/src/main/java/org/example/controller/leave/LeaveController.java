package org.example.controller.leave;

import feign.Param;
import lombok.extern.slf4j.Slf4j;
import org.example.service.leave.LeaveApplicationService;
import org.example.types.common.Response;
import org.example.types.leave.ro.CreateLeaveRo;
import org.example.types.leave.ro.SubmitApprovalRo;
import org.example.types.leave.vo.LeaveVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author
 */
@RestController
@RequestMapping("/leave")
@Slf4j
public class LeaveController {


    @Autowired
    LeaveApplicationService leaveApplicationService;

    @PostMapping
    public Response<?> createLeaveInfo(@RequestBody CreateLeaveRo createLeaveRo) {
        leaveApplicationService.createLeaveInfo(createLeaveRo);
        return Response.ok();
    }


    @PostMapping("/{leaveId}/submit")
    public Response<?> submitApproval(@PathVariable("leaveId") Integer leaveId, @RequestBody SubmitApprovalRo submitApprovalRo) {
        leaveApplicationService.submitApproval(leaveId,submitApprovalRo);
        return Response.ok();
    }

    @PostMapping("/{leaveId}")
    public Response<LeaveVo> findById(@PathVariable("leaveId") Integer leaveId) {
        LeaveVo leave = leaveApplicationService.getLeaveInfo(leaveId);
        return Response.<LeaveVo>ok(leave);
    }

    /**
     * 根据申请人查询所有请假单
     *
     * @param applicantId
     * @return
     */
    @PostMapping("/query/applicant/{applicantId}")
    public Response<List<LeaveVo>> queryByApplicant(@PathVariable(value = "applicantId") Integer applicantId) {
        List<LeaveVo> leaveList = leaveApplicationService.queryLeaveInfosByApplicant(applicantId);
        return Response.<List<LeaveVo>>ok(leaveList);
    }

    /**
     * 根据审批人id查询待审批请假单（待办任务）
     *
     * @param approverId
     * @return
     */
    @PostMapping("/query/approver/{approverId}")
    public Response<List<LeaveVo>> queryByApprover(@PathVariable(value = "approverId") Integer approverId) {
        List<LeaveVo> leaveList = leaveApplicationService.queryLeaveInfosByApprover(approverId);
        return Response.<List<LeaveVo>>ok(leaveList);
    }


    @PostMapping("/query/approver_name")
    public Response<List<LeaveVo>> queryByApproverName(@RequestParam(value = "name") String approverName) {
        List<LeaveVo> leaveList = leaveApplicationService.queryByApproverName(approverName);
        return Response.<List<LeaveVo>>ok(leaveList);
    }
}
