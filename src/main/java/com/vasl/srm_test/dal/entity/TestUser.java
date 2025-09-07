package com.vasl.srm_test.dal.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@Document(collection = "testUsers")
public class TestUser extends BaseEntity {
    private UserData data;
    private Support support;

    private Integer totalCount;
    private Integer monthlyCount;

    private LocalDateTime lastValidationTime;

    public TestUser() {
    }

    public TestUser(int id) {
        totalCount = null;
        monthlyCount = null;

        this.data = new UserData();
        this.data.setId(id);
        this.support = new Support();
    }
}
