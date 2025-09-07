package com.vasl.srm_test.service.model;


import com.vasl.srm_test.dal.entity.ApiRemoteProvider;
import lombok.Data;

@Data
public class TestUserLogOutputModel {
    private String testUserId;
    private String testUserDataId;
    private ApiRemoteProvider apiRemoteProvider;
}



