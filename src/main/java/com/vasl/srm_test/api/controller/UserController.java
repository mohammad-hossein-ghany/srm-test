package com.vasl.srm_test.api.controller;

import com.vasl.srm_test.api.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/srm/user")
@RestController
public class UserController {
    //tools
    private final UserFacade userFacade;

    public void getUser(int id){

    }
}
