package org.example.infrastructure.leave.repository.po;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 * @author sherry
 */
@Entity
@Table(name = "approval_info")
@Data
public class ApprovalInfoPo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDateTime createTime;

    private LocalDateTime lastModifyTime;

    private LocalDateTime deleteTime;

    private Integer leaveId;

    private Integer seq;

    private Integer approverId;

    private String approverName;

    private String approvalType;

    private String msg;

    private LocalDateTime approveTime;

}
