package org.example.domain.leave.repository.mapper;

import ddd.leave.domain.leave.repository.po.LeavePO;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveDao extends JpaRepository<LeavePO, String> {

    List<LeavePO> queryByApplicantId(String applicantId);

    List<LeavePO> queryByApproverId(String approverId);
}
