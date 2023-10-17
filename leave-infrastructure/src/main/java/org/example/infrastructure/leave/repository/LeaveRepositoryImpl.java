package org.example.infrastructure.leave.repository;

import java.util.List;
import org.example.domain.leave.repository.LeaveRepository;
import org.example.infrastructure.leave.repository.mapper.ApprovalInfoDao;
import org.example.infrastructure.leave.repository.mapper.LeaveDao;
import org.example.infrastructure.leave.repository.mapper.LeaveEventDao;
import org.example.infrastructure.leave.repository.po.ApprovalInfoPo;
import org.example.infrastructure.leave.repository.po.LeaveEventPo;
import org.example.infrastructure.leave.repository.po.LeavePo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
    LeaveEventDao leaveEventDao;

    public void save(LeavePo leavePO) {
        //persist leave entity
        leaveDao.save(leavePO);
       //set leave_id for approvalInfoPO after save leavePO
        leavePO.getHistoryApprovalInfoPOList().stream().forEach(approvalInfoPO -> approvalInfoPO.setLeaveId(leavePO.getId()));
        approvalInfoDao.saveAll(leavePO.getHistoryApprovalInfoPOList());
    }

    public void saveEvent(LeaveEventPo leaveEventPO){
        leaveEventDao.save(leaveEventPO);
    }

    @Override
    public LeavePo findById(String id) {
        return leaveDao.findById(id)
                .orElseThrow(() -> new RuntimeException("leave not found"));
    }

    @Override
    public List<LeavePo> queryByApplicantId(String applicantId) {
        List<LeavePo> leavePoList = leaveDao.queryByApplicantId(applicantId);
        leavePoList.stream()
                .forEach(leavePo -> {
                    List<ApprovalInfoPo> approvalInfoPoList = approvalInfoDao.queryByLeaveId(leavePo.getId());
                    leavePo.setHistoryApprovalInfoPOList(approvalInfoPoList);
                });
        return leavePoList;
    }

    @Override
    public List<LeavePo> queryByApproverId(String approverId) {
        List<LeavePo> leavePoList = leaveDao.queryByApproverId(approverId);
        leavePoList.stream()
                .forEach(leavePo -> {
                    List<ApprovalInfoPo> approvalInfoPoList = approvalInfoDao.queryByLeaveId(leavePo.getId());
                    leavePo.setHistoryApprovalInfoPOList(approvalInfoPoList);
                });
        return leavePoList;
    }

}
