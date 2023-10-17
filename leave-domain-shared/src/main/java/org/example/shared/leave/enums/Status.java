package org.example.shared.leave.enums;

import java.util.Arrays;
import java.util.Objects;

public enum Status {

    APPROVING,

    APPROVED,

    REJECTED;


    public static Status fromName(String name) {
        return Arrays.stream(Status.values())
                .filter(item -> Objects.equals(item.name(), name))
                .findFirst()
                .orElse(null);
    }
}
