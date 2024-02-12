package com.cloud.user.controller;

import com.cloud.user.entity.Result;
import com.cloud.user.entity.User;
import com.cloud.user.service.UserService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{userId}")
    public Result<User> getById(@PathVariable Long userId){
        log.info("get user details by {}", userId);
        return Result.success(userService.getById(userId));
    }

}
