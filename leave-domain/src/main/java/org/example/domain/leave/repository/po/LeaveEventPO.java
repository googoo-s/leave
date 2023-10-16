package org.example.domain.leave.repository.po;

import ddd.leave.domain.leave.event.LeaveEventType;
import java.util.Date;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
public class LeaveEventPO {

    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid") //这个是hibernate的注解/生成32位UUID
    @GeneratedValue(generator = "idGenerator")
    int id;
    @Enumerated(EnumType.STRING)
    LeaveEventType leaveEventType;
    Date timestamp;
    String source;
    String data;
}
