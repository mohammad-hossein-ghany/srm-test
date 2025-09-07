package com.vasl.srm_test.api.dto;


import com.vasl.srm_test.dal.entity.ApiRemoteProvider;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
public class TestUserLogInputDto {
    private String testUserId;
    private String testUserDataId;
    private ApiRemoteProvider apiRemoteProvider;
}



