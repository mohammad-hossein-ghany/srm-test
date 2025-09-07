package com.vasl.srm_test.service;

import com.vasl.srm_test.api.facade.mapper.TestUserMapper;
import com.vasl.srm_test.config.UrlApiConfig;
import com.vasl.srm_test.dal.entity.TestUser;
import com.vasl.srm_test.dal.repository.TestUserRepository;
import com.vasl.srm_test.service.model.TestUserOutputModel;
import com.vasl.srm_test.service.model.TestUserRemoteModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service
@RequiredArgsConstructor
public class TestUserServiceImpl implements TestUserService {
    //tools
    private final TestUserRepository testUserRepository;
    private final TestUserMapper testUserMapper;
    private final RestTemplate restTemplate;
    private final UrlApiConfig apiConfig;

    public LocalDateTime getExpireTime() {
        return LocalDateTime.now(ZoneId.of("Asia/Tehran")).plusMinutes(1);
    }


    private final String apiKey = "x-api-key";


//    @Override
//    public TestUserOutputModel getUserById(int id) {
//
//        Optional<TestUser> existedUserOpt = testUserRepository.findByUserDataId(id);
//        TestUser testUser;

    /// /        TestUser testUserResult;
//        if (!existedUserOpt.isPresent()) {
//            testUser = new TestUser(id);
//
//            callRemoteApiAndUpdateEntity(testUser);
//        }else {
//            testUser = existedUserOpt.get();
//            if (testUser.getLastValidationTime().isBefore(LocalDateTime.now())) {
//                callRemoteApiAndUpdateEntity(testUser);
//            }else {
//                return testUserMapper.entityToModel(testUser);
//            }
//        }
//        testUser.setLastValidationTime(getExpireTime());
//        testUser = testUserRepository.save(testUser);
//        return testUserMapper.entityToModel(testUser);
//    }
    private void callRemoteApiAndUpdateEntity(TestUser testUser) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(apiKey, apiConfig.getApiKeyValue());
        HttpEntity<Void> httpEntity = new HttpEntity<>(httpHeaders);
        String apiUrl = apiConfig.getUrl().replace("{id}", String.valueOf(testUser.getData().getId()));
        ResponseEntity<TestUserRemoteModel> response = restTemplate.exchange(apiUrl, HttpMethod.GET, httpEntity, TestUserRemoteModel.class);


        if (!response.getStatusCode().is2xxSuccessful()) {
            throw new RuntimeException("Failed to fetch user from remote API");
        }
        testUserMapper.fromRemoteModelToEntity(testUser, response.getBody());
    }

//    private TestUser callAndSaveUser(TestUser testUser) {
//
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.add(apiKey, apiConfig.getApiKeyValue());
//        HttpEntity<Void> httpEntity = new HttpEntity<>(httpHeaders);
//        String apiUrl = apiConfig.getUrl() + testUser.getData().getId();
//        ResponseEntity<TestUserRemoteModel> response = restTemplate.exchange(apiUrl, HttpMethod.GET, httpEntity, TestUserRemoteModel.class);
//
//
//        if (!response.getStatusCode().is2xxSuccessful()) {
//            throw new RuntimeException("Failed to fetch user from remote API");
//        }
//
//        TestUser entity;
//        if (existingEntity != null) {
//            entity = existingEntity;
//            testUserMapper.updateEntity(entity, response.getBody());
//        } else {
//            entity = testUserMapper.fromRemoteModelToEntity(response.getBody());
//        }
//
//        entity.setLastValidationTime(expireTime);
//        return testUserRepository.save(entity);
//    }

    //region old code
//
//    @Override
//    public TestUserOutputModel getUserById(int id) {
//        ZoneId zoneTehran = ZoneId.of("Asia/Tehran");
//        TestUser entity;
//        Optional<TestUser> existedTestUser = testUserRepository.findByUserDataId(id);
//        boolean isExpired = testUserRepository.isExpired(id, LocalDateTime.now(zoneTehran));
//
//        if (existedTestUser.isPresent()) {
//            if (!isExpired) {
//                entity = existedTestUser.get();
//            } else {
//
//                HttpHeaders httpHeaders = new HttpHeaders();
//                httpHeaders.add("x-api-key", "reqres-free-v1");
//                HttpEntity httpEntity = new HttpEntity(httpHeaders);
//                String apiUrl = "https://reqres.in/api/users/" + id;
//                ResponseEntity<TestUserRemoteModel> responseEntity = restTemplate.exchange(apiUrl, HttpMethod.GET, httpEntity, TestUserRemoteModel.class);
//                if (responseEntity.getStatusCode().is2xxSuccessful()) {
//                    entity = existedTestUser.get();
//
////                    entity = testUserMapper.fromRemoteModelToEntity(responseEntity.getBody());
////                    entity.setLastValidationTime(LocalDateTime.now().plusMinutes(1));
//                    testUserMapper.updateEntity(entity, responseEntity.getBody());
//                    entity.setLastValidationTime(LocalDateTime.now(zoneTehran).plusMinutes(1));
//                    entity = testUserRepository.save(entity);
//
//                } else {
//                    throw new RuntimeException();
//                }
//            }
//        } else {
//            HttpHeaders httpHeaders = new HttpHeaders();
//            httpHeaders.add("x-api-key", "reqres-free-v1");

    /// /            httpHeaders.set("", "");
//            HttpEntity httpEntity = new HttpEntity(httpHeaders);
//            String apiUrl = "https://reqres.in/api/users/" + id;
//            ResponseEntity<TestUserRemoteModel> responseEntity = restTemplate.exchange(apiUrl, HttpMethod.GET, httpEntity, TestUserRemoteModel.class);
//
//
//            if (responseEntity.getStatusCode().is2xxSuccessful()) {
//                entity = testUserMapper.fromRemoteModelToEntity(responseEntity.getBody());
//                entity.setLastValidationTime(LocalDateTime.now(zoneTehran).plusMinutes(1));
//                entity = testUserRepository.save(entity);
//
//            } else {
//                throw new RuntimeException();
//            }
//        }
//
//
//        return testUserMapper.entityToModel(entity);
//    }
//endregion

/*
    HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("x-api-key", "reqres-free-v1");
    //            httpHeaders.set("", "");
    HttpEntity httpEntity = new HttpEntity(httpHeaders);
    String apiUrl = "https://reqres.in/api/users/" + id;
    ResponseEntity<TestUserRemoteModel> responseEntity = restTemplate.exchange(apiUrl, HttpMethod.GET, httpEntity, TestUserRemoteModel.class);
*/
    @Override
    public void delete(int id) {
        TestUser entity = testUserRepository.findByUserDataId(id).orElseThrow();
        testUserRepository.delete(entity);
    }

    @Override
    public void deleteAll() {
        testUserRepository.deleteAll();
    }


    public TestUserOutputModel getUserById(int id) {

        TestUser testUser;
        Optional<TestUser> existedTestUser = testUserRepository.findByUserDataId(id);
        if (existedTestUser.isEmpty()) {
            testUser = new TestUser(id);
            callRemoteApiAndUpdateEntity(testUser);
        } else {
            testUser = existedTestUser.get();
            if (testUser.getLastValidationTime().isAfter(LocalDateTime.now())) {
                return testUserMapper.entityToModel(testUser);
            } else {
                callRemoteApiAndUpdateEntity(testUser);
            }
        }

        testUser.setLastValidationTime(getExpireTime());
        testUserRepository.save(testUser);
        return testUserMapper.entityToModel(testUser);

    }


}


