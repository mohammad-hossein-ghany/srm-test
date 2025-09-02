package com.vasl.srm_test.dal.repository;

import com.vasl.srm_test.dal.entity.TestUser;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TestUserRepository extends MongoRepository<TestUser, String> {
}
