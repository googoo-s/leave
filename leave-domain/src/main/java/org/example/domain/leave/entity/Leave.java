package org.example.domain.leave.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.Getter;
import org.example.common.domain.AggregateRoot;
import org.example.domain.leave.entity.valueobject.Applicant;
import org.example.domain.leave.entity.valueobject.Approver;
import org.example.shared.leave.enums.ApprovalType;
import org.example.shared.leave.enums.Status;
import org.example.util.DateUtil;
import org.springframework.util.CollectionUtils;

/**
 * 请假单信息
 *
 * @author sherry
 */
@Getter
public class Leave extends AggregateRoot {

    private Applicant applicant;
    private Approver approver;
    private String content;
    private Status status;
    private LocalDate startTime;
    private LocalDate endTime;
    private int maxAgreeCount;

    private List<ApprovalInfo> historyApprovalInfos;


    public Leave(Applicant applicant, Approver approver, String content, LocalDate startTime, LocalDate endTime,
                 int maxAgreeCount) {
        this(applicant, approver, content,
                maxAgreeCount == 0 ? Status.APPROVED : Status.APPROVING,
                startTime, endTime, maxAgreeCount, null);
    }

    public Leave(Applicant applicant, Approver approver, String content, Status status, LocalDate startTime,
                 LocalDate endTime, int maxAgreeCount, List<ApprovalInfo> historyApprovalInfos) {
        this.applicant = applicant;
        this.approver = approver;
        this.content = content;
        this.status = status;
        this.startTime = startTime;
        this.endTime = endTime;
        this.maxAgreeCount = maxAgreeCount;
        this.historyApprovalInfos = historyApprovalInfos;
        this.setCreateTime(LocalDateTime.now());
        this.setLastModifyTime(LocalDateTime.now());
        this.setDeleteTime(DateUtil.DEFAULT_DATE_TIME);
    }

    private void addHistory(ApprovalInfo info) {
        if (CollectionUtils.isEmpty(historyApprovalInfos)) {
            historyApprovalInfos = new ArrayList<>();
        }
        historyApprovalInfos.add(info);
    }


    public ApprovalInfo agree(Approver currentApprover, Approver nextApprover, String msg) {
        if (Arrays.asList(Status.REJECTED, Status.APPROVED).contains(status)) {
            throw new RuntimeException("已经审核完成了");
        }
        if (!approver.getPersonId().equals(currentApprover.getPersonId())) {
            throw new RuntimeException("你不能审核");
        }
        int infoSize = CollectionUtils.isEmpty(historyApprovalInfos) ? 0 : historyApprovalInfos.size();
        ApprovalInfo info = new ApprovalInfo(infoSize + 1, currentApprover, ApprovalType.AGREE, msg,
                LocalDateTime.now());
        addHistory(info);
        approver = nextApprover;
        if (historyApprovalInfos.size() == maxAgreeCount) {
            this.status = Status.APPROVED;
        }
        this.setLastModifyTime(LocalDateTime.now());
        return info;
    }

    public ApprovalInfo reject(Approver approver, String msg) {
        if (Arrays.asList(Status.REJECTED, Status.APPROVED).contains(status)) {
            throw new RuntimeException("已经审核完成了");
        }
        if (!approver.getPersonId().equals(approver.getPersonId())) {
            throw new RuntimeException("你不能审核");
        }

        int infoSize = CollectionUtils.isEmpty(historyApprovalInfos) ? 0 : historyApprovalInfos.size();

        ApprovalInfo info = new ApprovalInfo(infoSize + 1, approver, ApprovalType.REJECT, msg, LocalDateTime.now());
        addHistory(info);
        approver = null;
        this.status = Status.REJECTED;
        this.setLastModifyTime(LocalDateTime.now());
        return info;
    }

}
