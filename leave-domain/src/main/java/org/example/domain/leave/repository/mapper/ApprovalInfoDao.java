package org.example.domain.leave.repository.mapper;

import ddd.leave.domain.leave.repository.po.ApprovalInfoPO;
import ddd.leave.domain.leave.repository.po.LeavePO;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApprovalInfoDao extends JpaRepository<ApprovalInfoPO, String> {

    List<LeavePO> queryByApplicantId(String applicantId);

    List<ApprovalInfoPO> queryByLeaveId(String leaveId);

}
