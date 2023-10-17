package org.example.infrastructure.leave.repository.mapper;

import java.util.List;
import org.example.infrastructure.leave.repository.po.LeavePo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveDao extends JpaRepository<LeavePo, Integer> {

    List<LeavePo> queryByApplicantId(Integer applicantId);

    List<LeavePo> queryByApproverId(Integer approverId);
}
