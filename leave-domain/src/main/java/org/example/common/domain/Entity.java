package org.example.common.domain;

import java.time.LocalDateTime;
import lombok.Data;

/**
 * @author sherry
 */
@Data
public class Entity {

    private Integer id;

    private LocalDateTime createTime;

    private LocalDateTime lastModifyTime;

    private LocalDateTime deleteTime;
}
