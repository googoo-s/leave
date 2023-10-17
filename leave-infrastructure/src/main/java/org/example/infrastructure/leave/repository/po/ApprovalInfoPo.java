package org.example.infrastructure.leave.repository.po;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;
import org.example.common.repository.BaseEntity;
import org.hibernate.annotations.GenericGenerator;

/**
 * @author sherry
 */
@Entity
@Data
public class ApprovalInfoPo extends BaseEntity {

    private String leaveId;

    private String applicantId;

    private String approverId;

    private int approverLevel;

    private String approverName;

    private String msg;

    private long time;

}
