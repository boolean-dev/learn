package com.tao.retrofit.api.entity;

import lombok.Data;
import lombok.ToString;

/**
 * 用户
 *
 * @author Jiantao Yan
 * @title: User
 * @date 2021/1/28 16:33
 */
@Data
@ToString
public class User {

    private Long id;

    private String username;

    private Integer age;

    public User() {
    }

    public User(Long id, String username, Integer age) {
        this.id = id;
        this.username = username;
        this.age = age;
    }

    public User(String username, Integer age) {
        this.username = username;
        this.age = age;
    }
}
