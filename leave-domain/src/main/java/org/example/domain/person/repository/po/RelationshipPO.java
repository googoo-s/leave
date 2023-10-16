package org.example.domain.person.repository.po;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class RelationshipPO {

    @Id
    String id;
    String personId;
    String leaderId;
}
