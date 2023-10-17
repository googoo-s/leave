package org.example.infrastructure.leave.repository.po;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

/**
 * @author sherry
 */
@Data
@Entity
public class LeaveEventPo {

    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid") //这个是hibernate的注解/生成32位UUID
    @GeneratedValue(generator = "idGenerator")
    private int id;

    private String leaveEventType;

    private Date timestamp;

    private String source;

    private String data;
}
