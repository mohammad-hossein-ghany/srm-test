package com.vasl.srm_test.service;

import com.vasl.srm_test.dal.entity.ApiRemoteProvider;
import com.vasl.srm_test.dal.entity.TestUser;
import com.vasl.srm_test.dal.entity.TestUserLog;
import com.vasl.srm_test.dal.repository.TestUserLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class TestUserLogServiceImpl implements TestUserLogService {
    private final TestUserLogRepository testUserLogRepository;

    @Override
    public void addLog(TestUser testUser, ApiRemoteProvider apiRemoteProvider) {
        TestUserLog testUserLog = new TestUserLog(testUser.getId(), testUser.getData().getId(), apiRemoteProvider);
        testUserLogRepository.save(testUserLog);
    }


}
