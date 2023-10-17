package org.example.infrastructure.leave.repository.po;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

/**
 * @author sherry
 */
@Entity
@Table(name = "Leave")
@Data
public class LeavePo {

    @Id
    @GenericGenerator(name="idGenerator", strategy="uuid")
    @GeneratedValue(generator="idGenerator")
    private String id;
    private String applicantId;
    private String applicantName;
    private String applicantType;
    private String approverId;
    private String approverName;
    private String leaveType;
    private String status;
    private LocalDate startTime;
    private LocalDate endTime;
    private long duration;
}
