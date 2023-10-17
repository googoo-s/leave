package org.example.infrastructure.leave.repository.po;

import lombok.Data;
import org.example.common.repository.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

/**
 * @author sherry
 */
@Entity
@Table(name = "Leave")
@Data
public class LeavePo extends BaseEntity {
    private Integer applicantId;
    private String applicantName;
    private Integer approverId;
    private String approverName;
    private String content;
    private String status;
    private LocalDate startTime;
    private LocalDate endTime;
    private Integer maxAgreeCount;
}
