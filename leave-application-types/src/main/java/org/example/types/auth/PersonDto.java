package org.example.types.auth;

import lombok.Data;

/**
 * @author
 */
@Data
public class PersonDto {

    private String id;

    private String personName;

    private String roleId;

    private String personType;

    private String createTime;

    private String lastModifyTime;

    private String status;
}
