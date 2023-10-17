package org.example.shared.leave.enums;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author sherry
 */

public enum ApprovalType {

    AGREE,

    REJECT;

    public static ApprovalType fromName(String name) {
        return Arrays.stream(ApprovalType.values())
                .filter(item -> Objects.equals(item.name(), name))
                .findFirst()
                .orElse(null);
    }
}
