package org.example.infrastructure.leave.event;

import org.example.domain.leave.event.LeaveEvent;
import org.example.domain.leave.event.LeaveEventPublisher;
import org.springframework.stereotype.Component;

/**
 * @author sherry
 */
@Component
public class LeaveEventPublisherImpl implements LeaveEventPublisher {
    @Override
    public void publish(LeaveEvent event) {
        //send to MQ
        //mq.send(event);
    }
}
