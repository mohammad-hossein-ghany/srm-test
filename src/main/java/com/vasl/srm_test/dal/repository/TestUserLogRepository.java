package com.vasl.srm_test.dal.repository;

import com.vasl.srm_test.dal.entity.TestUserLog;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TestUserLogRepository extends MongoRepository<TestUserLog, String> {
}
