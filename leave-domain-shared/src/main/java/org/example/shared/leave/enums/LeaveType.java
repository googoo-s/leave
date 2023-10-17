package org.example.shared.leave.enums;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author sherry
 */

public enum LeaveType {

    Internal,

    External,

    Official;

    public static LeaveType fromName(String name) {
        return Arrays.stream(LeaveType.values())
                .filter(item -> Objects.equals(item.name(), name))
                .findFirst()
                .orElse(null);
    }
}
