package org.example.types.person.ro;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author sherry
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePersonRo {
    private String personName;
    private String province;
    private String city;
    private String exactAddress;
}
