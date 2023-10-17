package org.example.infrastructure.person.repository.po;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.common.repository.BaseEntity;
import org.hibernate.annotations.GenericGenerator;

/**
 * @author sherry
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class RelationshipPo extends BaseEntity {

    private String personId;
    private String leaderId;
}
