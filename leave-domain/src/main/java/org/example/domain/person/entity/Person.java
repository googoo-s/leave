package org.example.domain.person.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.example.common.domain.AggregateRoot;
import org.example.domain.person.entity.valueobject.Address;
import org.example.util.DateUtil;

import java.time.LocalDateTime;

/**
 * @author sherry
 */
@EqualsAndHashCode(callSuper = true)
public class Person extends AggregateRoot {

    @Getter
    private String personName;

    @Getter
    private Integer leaderId;

    @Getter
    private Address address;


    public Person(String personName, Address address) {
        this.personName = personName;
        this.address = address;
        this.setCreateTime(LocalDateTime.now());
        this.setLastModifyTime(LocalDateTime.now());
        this.setDeleteTime(DateUtil.DEFAULT_DATE_TIME);
    }

    public Person(Integer leaderId, String personName, Address address) {
        this(personName, address);
        this.leaderId = leaderId;
    }


    public void markModify() {
        this.setLastModifyTime(LocalDateTime.now());
    }

    public void delete() {
        this.setDeleteTime(LocalDateTime.now());
    }

    public void changeLeader(Integer leaderId) {
        this.leaderId = leaderId;
        markModify();

    }


}