package org.example.infrastructure.leave.repository.po;

import lombok.Data;
import org.example.common.repository.BaseEntity;

import javax.persistence.Entity;
import java.time.LocalDateTime;

/**
 * @author sherry
 */
@Entity
@Data
public class ApprovalInfoPo extends BaseEntity {

    private Integer leaveId;

    private Integer seq;

    private Integer approverId;

    private String approverName;

    private String approvalType;

    private String msg;

    private LocalDateTime approveTime;

}
