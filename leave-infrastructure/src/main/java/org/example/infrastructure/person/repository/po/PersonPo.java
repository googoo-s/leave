package org.example.infrastructure.person.repository.po;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.common.repository.BaseEntity;

/**
 * @author sherry
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "person")
public class PersonPo extends BaseEntity {
    private String personName;
    private String personType;
    private int roleLevel;
    private String status;
}
