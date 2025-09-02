package com.vasl.srm_test.dal.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "testUsers")
public class TestUser extends BaseEntity {
    private UserData data;
    private Support support;

    private LocalDateTime lastValidationTime;
}
