package org.example.types.auth;

import lombok.Data;

/**
 * @author
 */
@Data
public class PersonDTO {
    String personId;
    String personName;
    String roleId;
    String personType;
    String createTime;
    String lastModifyTime;
    String status;
}
