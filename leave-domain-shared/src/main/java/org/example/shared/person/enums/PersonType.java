package org.example.shared.person.enums;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author sherry
 */

public enum PersonType {

    /**
     * 内部
     */
    INTERNAL,

    /**
     * 外部
     */
    EXTERNAL;


    public static PersonType fromName(String name) {
        return Arrays.stream(PersonType.values())
                .filter(item -> Objects.equals(item.name(), name))
                .findFirst()
                .orElse(null);
    }
}
