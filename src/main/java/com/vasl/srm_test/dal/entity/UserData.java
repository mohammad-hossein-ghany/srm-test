package com.vasl.srm_test.dal.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
public class UserData {
    @Field("id")
    private Integer id;
    private String email;
    @Field("first_name")
    private String firstName;
    @Field("last_name")
    private String lastName;
    private String avatar;
}
