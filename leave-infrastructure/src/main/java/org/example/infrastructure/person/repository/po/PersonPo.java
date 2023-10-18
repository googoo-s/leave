package org.example.infrastructure.person.repository.po;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 * @author sherry
 */
@Data
@Entity
@Table(name = "person")
public class PersonPo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime createTime;
    private LocalDateTime lastModifyTime;
    private LocalDateTime deleteTime;
    private String personName;
    private Integer leaderId;
    private String province;
    private String city;
    private String exactAddress;
}
