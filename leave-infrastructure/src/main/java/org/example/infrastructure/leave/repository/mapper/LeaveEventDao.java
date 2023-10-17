package org.example.infrastructure.leave.repository.mapper;

import org.example.infrastructure.leave.repository.po.LeaveEventPo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author sherry
 */
@Repository
public interface LeaveEventDao extends JpaRepository<LeaveEventPo, String> {

}
