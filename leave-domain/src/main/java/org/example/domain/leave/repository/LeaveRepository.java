package org.example.domain.leave.repository;

import org.example.domain.leave.entity.Leave;

import java.util.List;

/**
 * @author sherry
 */
public interface LeaveRepository {

    void save(Leave leave);


    Leave findById(Integer id);

    List<Leave> queryByApplicantId(Integer applicantId);

    List<Leave> queryByApproverId(Integer approverId);

}