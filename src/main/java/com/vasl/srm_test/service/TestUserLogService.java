package com.vasl.srm_test.service;

import com.vasl.srm_test.dal.entity.ApiRemoteProvider;
import com.vasl.srm_test.dal.entity.TestUser;

public interface TestUserLogService {
    void addLog(TestUser testUser, ApiRemoteProvider apiRemoteProvider);
}
