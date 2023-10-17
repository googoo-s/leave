package org.example.infrastructure.rule.repository.po;

import javax.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.common.repository.BaseEntity;

/**
 * @author sherry
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class ApprovalRulePO extends BaseEntity {

    private String leaveType;

    private String personType;

    private long duration;

    private String applicantRoleId;
}
