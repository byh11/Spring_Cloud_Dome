package com.org.controller;

import com.org.entity.User;
import com.org.service.UserServiceimpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
@RefreshScope
public class UserController {

    @Autowired
    private UserServiceimpl userServiceimpl;

    @Value("${user.a}")
    String a;

    @RequestMapping("/get")
    @ResponseBody
    public String get() {
        return a;
    }

    @RequestMapping("/user")
    @ResponseBody
    public User user(@Param("id") int id) {
        User user = userServiceimpl.getUser(id);
        System.out.println(user);
        return user;
    }
}
