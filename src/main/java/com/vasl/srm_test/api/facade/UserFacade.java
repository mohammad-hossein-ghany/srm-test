package com.vasl.srm_test.api.facade;

import com.vasl.srm_test.api.facade.mapper.SupportMapper;
import com.vasl.srm_test.api.facade.mapper.TestUserMapper;
import com.vasl.srm_test.api.facade.mapper.UserDataMapper;
import com.vasl.srm_test.service.TestUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class UserFacade {
    //tools
    private final TestUserService testUserService;
    private final TestUserMapper  testUserMapper;
    private final UserDataMapper   userDataMapper;
    private final SupportMapper  supportMapper;

}
