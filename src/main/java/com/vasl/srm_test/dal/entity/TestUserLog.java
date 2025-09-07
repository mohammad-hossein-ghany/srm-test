package com.vasl.srm_test.dal.entity;


import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "testUsersLogs")
public class TestUserLog {
    @Id
    private String id;
    @CreatedDate
    protected LocalDateTime createdDate;

    private String testUserId;
    private Integer testUserDataId;
    private ApiRemoteProvider apiRemoteProvider;

    public TestUserLog() {
    }

    public TestUserLog(String testUserId, Integer testUserDataId, ApiRemoteProvider apiRemoteProvider) {
        this.testUserId = testUserId;
        this.testUserDataId = testUserDataId;
        this.apiRemoteProvider = apiRemoteProvider;

    }

}



