package com.org.service;

import com.org.entity.User;
import com.org.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceimpl implements UserService{

    @Autowired
    private UserMapper userMapper;
    @Override
    public User getUser(int id) {
        System.out.println("user-service");
        return userMapper.selectById(id);
    }
}
