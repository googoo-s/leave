package org.example.domain.person.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.common.domain.Entity;

/**
 * @author sherry
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Relationship extends Entity {

    private String personId;

    private String leaderId;
}
