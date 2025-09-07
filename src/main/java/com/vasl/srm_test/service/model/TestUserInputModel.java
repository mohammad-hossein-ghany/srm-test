package com.vasl.srm_test.service.model;

import com.vasl.srm_test.dal.entity.BaseEntity;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
public class TestUserInputModel {
    private UserDataInputModel data;
    private SupportInputModel support;

    private Integer totalCount;
    private Integer monthlyCount;

    private LocalDateTime lastValidationTime;
}
