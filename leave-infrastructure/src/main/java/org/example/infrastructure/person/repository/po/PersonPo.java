package org.example.infrastructure.person.repository.po;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.common.repository.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author sherry
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "person")
public class PersonPo extends BaseEntity {
    private String personName;
    private Integer leaderId;
    private String province;
    private String city;
    private String exactAddress;
}
