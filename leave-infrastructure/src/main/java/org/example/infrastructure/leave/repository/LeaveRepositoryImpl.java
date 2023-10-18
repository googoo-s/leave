package org.example.infrastructure.leave.repository;

import org.example.domain.leave.entity.Leave;
import org.example.domain.leave.repository.LeaveRepository;
import org.example.infrastructure.leave.converter.LeaveFactory;
import org.example.infrastructure.leave.repository.mapper.ApprovalInfoDao;
import org.example.infrastructure.leave.repository.mapper.LeaveDao;
import org.example.infrastructure.leave.repository.po.ApprovalInfoPo;
import org.example.infrastructure.leave.repository.po.LeavePo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * persist entity and handle event in repository
 */
@Repository
public class LeaveRepositoryImpl implements LeaveRepository {

    @Autowired
    LeaveDao leaveDao;
    @Autowired
    ApprovalInfoDao approvalInfoDao;
    @Autowired
    LeaveFactory leaveFactory;


    @Override
    public void save(Leave leave) {
        LeavePo leavePo = leaveFactory.leavePoFromDo(leave);
        leaveDao.save(leavePo);
        if (!CollectionUtils.isEmpty(leave.getHistoryApprovalInfos())) {
            List<ApprovalInfoPo> approvalInfoPoList = leave.getHistoryApprovalInfos().stream()
                    .map(approvalInfoPO -> leaveFactory.approvalInfoPoFromDo(leavePo, approvalInfoPO))
                    .collect(Collectors.toList());
            approvalInfoDao.saveAll(approvalInfoPoList);
        }
    }


    @Override
    public Leave findById(Integer id) {
        LeavePo leavePo = leaveDao.findById(id).orElseThrow(() -> new RuntimeException("leave not found"));
        List<ApprovalInfoPo> approvalInfoPos = approvalInfoDao.queryByLeaveId(leavePo.getId());
        return leaveFactory.leaveDoFromPo(leavePo, approvalInfoPos);
    }

    @Override
    public List<Leave> queryByApplicantId(Integer applicantId) {
        List<LeavePo> leavePoList = leaveDao.queryByApplicantId(applicantId);
        return leavePoList.stream()
                .map(leavePo -> {
                    List<ApprovalInfoPo> approvalInfoPoList = approvalInfoDao.queryByLeaveId(leavePo.getId());
                    return leaveFactory.leaveDoFromPo(leavePo, approvalInfoPoList);
                }).collect(Collectors.toList());
    }

    @Override
    public List<Leave> queryByApproverId(Integer approverId) {
        List<LeavePo> leavePoList = leaveDao.queryByApproverId(approverId);
        return leavePoList.stream()
                .map(leavePo -> {
                    List<ApprovalInfoPo> approvalInfoPoList = approvalInfoDao.queryByLeaveId(leavePo.getId());
                    return leaveFactory.leaveDoFromPo(leavePo, approvalInfoPoList);
                }).collect(Collectors.toList());
    }

}
