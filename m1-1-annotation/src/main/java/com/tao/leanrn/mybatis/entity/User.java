package com.tao.leanrn.mybatis.entity;

import lombok.Data;

/**
 * @ClassName User
 * @Descriiption 用户实体类
 * @Author yanjiantao
 * @Date 2019/6/28 15:24
 **/
@Data
public class User {
    private Integer id;
    private String username;
    private String password;
}
