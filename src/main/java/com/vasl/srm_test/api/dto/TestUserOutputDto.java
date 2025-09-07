package com.vasl.srm_test.api.dto;

import com.vasl.srm_test.dal.entity.BaseEntity;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
public class TestUserOutputDto{
    private UserDataOutputDto data;
    private SupportOutputDto support;

    private Integer totalCount;
    private Integer monthlyCount;

    private LocalDateTime lastValidationTime;
}
