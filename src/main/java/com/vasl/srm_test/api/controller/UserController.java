package com.vasl.srm_test.api.controller;

import com.vasl.srm_test.api.dto.TestUserOutputDto;
import com.vasl.srm_test.api.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/srm/users")
@RestController
public class UserController {
    //tools
    private final UserFacade userFacade;

    @GetMapping("/{id}")
    public TestUserOutputDto getUserById(@PathVariable int id) {
        return userFacade.getUserById(id);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        userFacade.delete(id);
    }

    @DeleteMapping
    public void deleteAll() {
        userFacade.deleteAll();
    }
}
