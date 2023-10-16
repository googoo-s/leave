package org.example.domain.person.entity;

import lombok.Data;
import org.example.domain.person.entity.valueobject.PersonStatus;
import org.example.domain.person.entity.valueobject.PersonType;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Person {

    String personId;
    String personName;
    PersonType personType;
    List<Relationship> relationships;
    int roleLevel;
    LocalDateTime createTime;
    LocalDateTime lastModifyTime;
    PersonStatus status;

    public Person create(){
        this.createTime = LocalDateTime.now();
        this.status = PersonStatus.ENABLE;
        return this;
    }

    public Person enable(){
        this.lastModifyTime = LocalDateTime.now();
        this.status = PersonStatus.ENABLE;
        return this;
    }

    public Person disable(){
        this.lastModifyTime = LocalDateTime.now();
        this.status = PersonStatus.DISABLE;
        return this;
    }
}