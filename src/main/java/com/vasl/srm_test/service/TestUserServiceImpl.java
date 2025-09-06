package com.vasl.srm_test.service;

import com.vasl.srm_test.api.facade.mapper.SupportMapper;
import com.vasl.srm_test.api.facade.mapper.TestUserMapper;
import com.vasl.srm_test.api.facade.mapper.UserDataMapper;
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

@Service
@RequiredArgsConstructor
public class TestUserServiceImpl implements TestUserService {
    //tools
    private final TestUserRepository testUserRepository;
    private final TestUserMapper testUserMapper;
    private final UserDataMapper userDataMapper;
    private final SupportMapper supportMapper;
    private final RestTemplate restTemplate;


    @Override
    public TestUserOutputModel getUserById(int id) {
        TestUser entity;
        boolean isExist = testUserRepository.existsByDataId(id);
        boolean isExpired = testUserRepository.isExpired(id, LocalDateTime.now());

        if (isExist) {
            if (!isExpired) {
                entity = testUserRepository.findByUserDataId(id).orElseThrow();
            } else {
                String apiUrl = "https://reqres.in/api/users/" + id;
                TestUser expiredEntity = testUserRepository.findByUserDataId(id).orElseThrow();
                entity = restTemplate.getForObject(apiUrl, TestUser.class);


                if (entity != null) {
                    testUserMapper.updateEntity(entity, expiredEntity);
//                    entity.setLastValidationTime(LocalDateTime.now().plusDays(1));
                    entity.setLastValidationTime(LocalDateTime.now().plusMinutes(1));
                    entity = testUserRepository.save(expiredEntity);
                }
            }
        } else {
            HttpHeaders httpHeaders = new HttpHeaders();
//            httpHeaders.set("", "");
            HttpEntity httpEntity = new HttpEntity(httpHeaders);
            String apiUrl = "https://reqres.in/api/users/" + id;
            ResponseEntity<TestUserRemoteModel> responseEntity = restTemplate.exchange(apiUrl, HttpMethod.GET, httpEntity, TestUserRemoteModel.class);
//            if (model != null) {
//                entity.setLastValidationTime(LocalDateTime.now().plusDays(1));
//                entity.setLastValidationTime(LocalDateTime.now().plusMinutes(1));
//                entity = testUserRepository.save(entity);
//            }
            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                entity = testUserMapper.fromRemoteModelToEntity(responseEntity.getBody());
                entity = testUserRepository.save(entity);

            } else {
                throw new RuntimeException();
            }
        }


        return testUserMapper.entityToModel(entity);

//        TestUser x = testUserRepository.findByUserDataId(id);
//
//        // مرحله اول: چک توی Mongo
//        return testUserRepository.findByUserDataId(id)
//                .filter(user -> user.getLastValidationTime().isAfter(LocalDateTime.now()))
//                .orElseGet(() -> {
//                    // مرحله دوم: اگر نبود یا منقضی شده → API اصلی
//                    String apiUrl = "https://reqres.in/api/users/" + id;
//                    TestUser response = restTemplate.getForObject(apiUrl, TestUser.class);
//
//                    // مرحله سوم: ذخیره در Mongo با expire 24 ساعت
//                    TestUser newUser = new TestUser();
//                    newUser.setData(response.getData());
//                    newUser.setSupport(response.getSupport());
//                    newUser.setLastValidationTime(LocalDateTime.now().plusHours(24));
//
//                    TestUser entity = testUserRepository.save(newUser);
//                    return testUserMapper.entityToModel(entity);
//                });
//


    }

    @Override
    public void delete(int id) {
        TestUser entity = testUserRepository.findByUserDataId(id).orElseThrow();
        testUserRepository.delete(entity);
    }

    @Override
    public void deleteAll() {
        testUserRepository.deleteAll();
    }
}















