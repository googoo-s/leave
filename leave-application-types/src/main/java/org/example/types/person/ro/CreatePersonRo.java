package org.example.types.person.ro;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CreatePersonRo {
    private String personName;
    private String province;
    private String city;
    private String exactAddress;
}
