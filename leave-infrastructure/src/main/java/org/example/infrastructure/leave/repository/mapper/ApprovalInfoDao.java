package org.example.infrastructure.leave.repository.mapper;

import java.util.List;
import org.example.infrastructure.leave.repository.po.ApprovalInfoPo;
import org.example.infrastructure.leave.repository.po.LeavePo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author sherry
 */
@Repository
public interface ApprovalInfoDao extends JpaRepository<ApprovalInfoPo, String> {

    List<LeavePo> queryByApplicantId(String applicantId);

    List<ApprovalInfoPo> queryByLeaveId(String leaveId);

}
