package org.example.domain.leave.event;

/**
 * @author sherry
 */

public interface LeaveEventPublisher {

    void publish(LeaveEvent event);
}
