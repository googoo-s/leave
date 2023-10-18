package org.example.infrastructure.leave.repository.mapper;

import java.util.List;
import org.example.infrastructure.leave.repository.po.LeavePo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author sherry
 */
@Repository
public interface LeaveDao extends JpaRepository<LeavePo, Integer> {

    @Query(value = "select * from leaved where delete_time = '1970-01-01 00:00:00' and applicant_id = ?",
            nativeQuery = true)
    List<LeavePo> queryByApplicantId(Integer applicantId);

    @Query(value = "select * from leaved where delete_time = '1970-01-01 00:00:00' and approver_id = ?",
            nativeQuery = true)
    List<LeavePo> queryByApproverId(Integer approverId);

    @Query(value = "select distinct l.id\n"
            + "from person a\n"
            + "         join approval_info ai on a.id = ai.approver_Id\n"
            + "         join leaved l on ai.leave_Id = l.id\n"
            + "where a.delete_time = '1970-01-01 00:00:00:'\n"
            + "  and ai.delete_time = '1970-01-01 00:00:00:'\n"
            + "  and l.delete_time = '1970-01-01 00:00:00:'\n"
            + "  and a.person_name like %?%",
            nativeQuery = true)
    List<Integer> queryIdApprovedByApproverName(String approveName);
}
