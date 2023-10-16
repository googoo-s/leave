package org.example.domain.leave.event;

import com.alibaba.fastjson.JSON;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.common.event.DomainEvent;
import org.example.domain.leave.entity.Leave;
import org.example.util.IdGenerator;

/**
 * @author sherry
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class LeaveEvent extends DomainEvent {

    LeaveEventType leaveEventType;

    public static LeaveEvent create(LeaveEventType eventType, Leave leave) {
        LeaveEvent event = new LeaveEvent();
        event.setId(IdGenerator.nextId());
        event.setLeaveEventType(eventType);
        event.setTimestamp(new Date());
        event.setData(JSON.toJSONString(leave));
        return event;
    }
}
