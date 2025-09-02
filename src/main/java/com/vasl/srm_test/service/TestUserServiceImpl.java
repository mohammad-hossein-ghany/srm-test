package com.vasl.srm_test.service;

import com.vasl.srm_test.api.facade.mapper.SupportMapper;
import com.vasl.srm_test.api.facade.mapper.TestUserMapper;
import com.vasl.srm_test.api.facade.mapper.UserDataMapper;
import com.vasl.srm_test.dal.repository.TestUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestUserServiceImpl implements TestUserService {
    //tools
    private final TestUserRepository testUserRepository;
    private final TestUserMapper testUserMapper;
    private final UserDataMapper userDataMapper;
    private final SupportMapper supportMapper;
}
