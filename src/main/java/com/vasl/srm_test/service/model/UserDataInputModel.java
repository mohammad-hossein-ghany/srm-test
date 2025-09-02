package com.vasl.srm_test.service.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
public class UserDataInputModel {
    private Integer id;
    private String email;
    private String firstName;
    private String lastName;
    private String avatar;
}
