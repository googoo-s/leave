package org.example.domain.person.entity.valueobject;

import lombok.Builder;
import lombok.Data;

/**
 * @author
 */
@Data
@Builder
public class Address {
    private String province;
    private String city;
    private String exactAddress;
}
