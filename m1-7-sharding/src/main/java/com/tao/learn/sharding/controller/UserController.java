package com.tao.learn.sharding.controller;

import com.tao.learn.sharding.entity.User;
import com.tao.learn.sharding.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Jiantao Yan
 * @description: 用户Controller层
 * @title: UserController
 * @date 2019/12/24 15:13
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/transaction")
    public List<User> transaction(@RequestBody User user) {
        return userService.transaction(user);
    }

    @PostMapping("/")
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    @PutMapping("/")
    public Object update(User user) {
        userService.update(user);
        Map<String, Object> result = new HashMap<>(2);
        result.put("code", 200);
        result.put("msg", "更新成功");
        return result;
    }

    @DeleteMapping("/{id}")
    public Object save(@PathVariable(name = "id") Long id) {
        userService.delete(id);
        Map<String, Object> result = new HashMap<>(2);
        result.put("code", 200);
        result.put("msg", "更新成功");
        return result;
    }
}
