package org.example.infrastructure.leave.repository.po;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.common.repository.BaseEntity;

import javax.persistence.Entity;
import java.time.LocalDateTime;

/**
 * @author sherry
 */
//@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "approval_info")
@Data
public class ApprovalInfoPo  {

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
