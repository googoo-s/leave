package org.example.types.person.ro;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangeLeaderRo {
    private Integer leaderId;
}
