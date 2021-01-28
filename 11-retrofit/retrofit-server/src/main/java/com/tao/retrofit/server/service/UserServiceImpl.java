package com.tao.retrofit.server.service;

import com.tao.retrofit.api.entity.User;
import com.tao.retrofit.api.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * user service impl
 *
 * @author Jiantao Yan
 * @title: UserImpl
 * @date 2021/1/28 16:41
 */
@Slf4j
@RequestMapping("/user")
@RestController
public class UserServiceImpl implements UserService {
    @Override
    @PostMapping
    public User save(@RequestBody User user) {
        log.info("------->user.save,user={}", user);
        user.setId(System.currentTimeMillis());
        return user;
    }

    @Override
    @GetMapping
    public List<User> list() {
        List<User> userList = new ArrayList<>(5);
        for (int i = 0; i < 5; i++) {
            userList.add(new User((long) i, "xiaoming" + i, i+20));
        }
        userList.forEach(user -> log.info("------->user.list,user={}", user));
        return userList;
    }

    @Override
    @GetMapping("/{id}")
    public User get(@PathVariable("id") Long id) {
        return new User(id, "booleandev", 24);
    }

    @Override
    @PutMapping
    public User update(@RequestBody User user) {
        log.info("------->user.update,user={}", user);
        user.setId(System.currentTimeMillis());
        user.setUsername(user.getUsername() + "__update");
        user.setAge(user.getAge() + 5);
        log.info("------->user.update,result,user={}", user);
        return user;
    }

    @Override
    @DeleteMapping
    public Void delete(Long id) {
        log.info("------->user.delete,id={}", id);
        return null;
    }
}
