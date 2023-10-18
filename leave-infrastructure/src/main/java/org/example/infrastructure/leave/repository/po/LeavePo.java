package org.example.infrastructure.leave.repository.po;

import java.time.LocalDate;
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
@Table(name = "leave")
@Data
public class LeavePo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime createTime;
    private LocalDateTime lastModifyTime;
    private LocalDateTime deleteTime;
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
