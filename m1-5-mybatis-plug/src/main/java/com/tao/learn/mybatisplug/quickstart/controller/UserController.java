package com.tao.learn.mybatisplug.quickstart.controller;

import com.tao.learn.mybatisplug.quickstart.entity.User;
import com.tao.learn.mybatisplug.quickstart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 用户Controller
 *
 * @author 谛听
 * @date 2019/11/7 11:23
 **/

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(name = "/list")
    public List<User> list() {
        List<User> userList = userService.list();
        return userList;
    }

    @PostMapping(name = "/insert")
    public Boolean insert(User user) {
        user.setCreateTime(LocalDateTime.now()).setUpdateTime(LocalDateTime.now());
        return userService.save(user);
    }
}