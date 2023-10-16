package org.example.types.auth;

import lombok.Data;

/**
 * @author
 */
@Data
public class PersonDTO {

    private String personId;

    private String personName;

    private String roleId;

    private String personType;

    private String createTime;

    private String lastModifyTime;

    private String status;
}
