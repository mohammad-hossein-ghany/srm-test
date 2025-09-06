package com.vasl.srm_test.service;

import com.vasl.srm_test.dal.entity.TestUser;
import com.vasl.srm_test.service.model.TestUserOutputModel;

public interface TestUserService {
    TestUserOutputModel getUserById(int id);
    public void delete(int id);

    void deleteAll();
}
