package org.example.common.event;

import java.util.Date;
import lombok.Data;

/**
 * @author sherry
 */
@Data
public class DomainEvent {
    String id;
    Date timestamp;
    String source;
    String data;
}
