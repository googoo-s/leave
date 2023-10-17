package org.example.types.person.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LeaderLineVo {
    private Integer id;
    private String personName;
    private Integer leaderId;
    private String province;
    private String city;
    private String exactAddress;

}
