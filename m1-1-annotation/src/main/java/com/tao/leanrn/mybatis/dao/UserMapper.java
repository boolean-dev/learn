package com.tao.leanrn.mybatis.dao;

import com.tao.leanrn.mybatis.annotation.Delete;
import com.tao.leanrn.mybatis.annotation.Insert;
import com.tao.leanrn.mybatis.annotation.Select;
import com.tao.leanrn.mybatis.annotation.Update;
import com.tao.leanrn.mybatis.entity.User;

import java.util.List;

public interface UserMapper {
    @Insert("insert into user (username,password) values (?,?)")
    public void addUser(String name, String password);

    @Select("select * from user")
    public List<User> findUsers();

    @Select("select * from user where name = ?")
    public User getUser(String name);

    @Update("update user set username = ? , password=? where id=?")
    public Integer updateUser(String name, String password, Integer id);

    @Delete("delete from user where name=?")
    public void deleteUser(String name);
}
