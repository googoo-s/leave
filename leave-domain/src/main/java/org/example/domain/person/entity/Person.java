package org.example.domain.person.entity;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.common.domain.AggregateRoot;
import org.example.shared.person.enums.PersonStatus;
import org.example.shared.person.enums.PersonType;
import org.example.util.DateUtil;
import org.springframework.util.CollectionUtils;

/**
 * @author sherry
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Person extends AggregateRoot {

    private String personName;

    private PersonType personType;

    private int roleLevel;

    private PersonStatus status;



    private List<Relationship> relationships;


    public void init() {
        this.setCreateTime(LocalDateTime.now());
        this.setLastModifyTime(LocalDateTime.now());
        this.setDeleteTime(DateUtil.DEFAULT_DATE_TIME);
        this.relationships = null;
        this.status = PersonStatus.ENABLE;
    }


    public void enable() {
        markModify();
        this.status = PersonStatus.ENABLE;
    }


    public void disable() {
        markModify();
        this.status = PersonStatus.DISABLE;
    }

    public void markModify() {
        this.setLastModifyTime(LocalDateTime.now());
    }

    public void delete() {
        this.setDeleteTime(LocalDateTime.now());
    }

    public void addSubordinate(Person subordinate) {
        if (CollectionUtils.isEmpty(relationships))
    }
}