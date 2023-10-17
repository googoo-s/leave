package org.example.domain.leave.entity;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.Getter;
import org.example.common.domain.Entity;
import org.example.shared.leave.enums.ApprovalType;
import org.example.domain.leave.entity.valueobject.Approver;
import org.example.util.DateUtil;

/**
 * @author sherry
 */
@Getter
public class ApprovalInfo extends Entity {


    private int seq;
    private Approver approver;
    private ApprovalType approvalType;
    private String msg;
    private LocalDateTime approveTime;


    public ApprovalInfo(int seq, Approver approver, ApprovalType approvalType, String msg, LocalDateTime approveTime) {
        this.seq = seq;
        this.approver = approver;
        this.approvalType = approvalType;
        this.msg = msg;
        this.approveTime = approveTime;
        this.setCreateTime(LocalDateTime.now());
        this.setLastModifyTime(LocalDateTime.now());
        this.setDeleteTime(DateUtil.DEFAULT_DATE_TIME);
    }

}
