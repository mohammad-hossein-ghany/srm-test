package com.vasl.srm_test.api.dto;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
public class UserDataInputDto {
    private Integer id;
    private String email;
    private String firstName;
    private String lastName;
    private String avatar;
}
