package org.example.common.repository;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

/**
 * @author
 */
@Data
public class BaseEntity {
    @Id
    @GeneratedValue(generator = "idGenerator")
    private Integer id;

    private LocalDateTime createTime;

    private LocalDateTime lastModifyTime;

    private LocalDateTime deleteTime;

}
