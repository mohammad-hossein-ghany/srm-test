package com.vasl.srm_test.dal.repository;

import com.vasl.srm_test.dal.entity.TestUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.time.LocalDateTime;
import java.util.Optional;

public interface TestUserRepository extends MongoRepository<TestUser, String> {

    @Query("{ 'data.id': ?0 }")
    Optional<TestUser> findByUserDataId(Integer userId);

    @Query(value = "{ 'data.id': ?0 }", exists = true)
    boolean existsByDataId(Integer userId);

    @Query(value = "{'lastValidationTime': { $lte: ?0 } }", exists = true)
    boolean isExpired(LocalDateTime now);

    @Query(value = "{ 'data.id': ?0, 'lastValidationTime': { $lte: ?1 } }", exists = true)
    boolean isExpired(Integer userId, LocalDateTime now);




}
