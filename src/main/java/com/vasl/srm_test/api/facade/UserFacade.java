package com.vasl.srm_test.api.facade;

import com.vasl.srm_test.api.dto.TestUserOutputDto;
import com.vasl.srm_test.api.facade.mapper.SupportMapper;
import com.vasl.srm_test.api.facade.mapper.TestUserMapper;
import com.vasl.srm_test.api.facade.mapper.UserDataMapper;
import com.vasl.srm_test.service.TestUserService;
import com.vasl.srm_test.service.model.TestUserOutputModel;
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

    public TestUserOutputDto getUserById(int id) {
        TestUserOutputModel testUserOutputModel=  testUserService.getUserById(id);
        return testUserMapper.modelToDto(testUserOutputModel);
    }

    public void delete(int id) {
        testUserService.delete(id);
    }
}
