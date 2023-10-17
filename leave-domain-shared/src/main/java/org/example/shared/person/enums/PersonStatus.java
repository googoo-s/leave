package org.example.shared.person.enums;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author sherry
 */

public enum PersonStatus {

    /**
     * 可用
     */

    ENABLE,

    /**
     * 不可用
     */
    DISABLE;

    public static PersonStatus fromName(String name) {
        return Arrays.stream(PersonStatus.values())
                .filter(item -> Objects.equals(item.name(), name))
                .findFirst()
                .orElse(null);
    }

}
