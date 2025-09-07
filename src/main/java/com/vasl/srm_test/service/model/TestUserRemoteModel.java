package com.vasl.srm_test.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vasl.srm_test.dal.entity.BaseEntity;
import com.vasl.srm_test.dal.entity.Support;
import com.vasl.srm_test.dal.entity.UserData;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Data
public class TestUserRemoteModel {
    private UserDataRemoteOutputModel data;
    private SupportRemoteOutputModel support;

    @Data
    public static class UserDataRemoteOutputModel {

        private String id;

        private String email;

        @JsonProperty("first_name")
        private String firstName;

        @JsonProperty("last_name")
        private String lastName;

        private String avatar;
    }

    @Data
    public static class SupportRemoteOutputModel {
        private String url;
        private String text;
    }
}
