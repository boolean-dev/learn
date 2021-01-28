package com.tao.retrofit.api.service;

import com.tao.retrofit.api.entity.User;
import retrofit2.http.*;

import java.util.List;

/**
 * 用户接口
 *
 * @author Jiantao Yan
 * @title: UserService
 * @date 2021/1/28 16:35
 */
public interface UserService {

    /**
     * 保存
     * @param user  user
     * @return  user
     */
    @POST("user")
    User save(@Body User user);

    /**
     * 列表
     * @return  list of user
     */
    @GET("user")
    List<User> list();

    /**
     * get by id
     * @param id    id
     * @return  user
     */
    @GET("user/{id}")
    User get(@Path("id") Long id);

    /**
     * 更新
     * @param user  user
     * @return  user
     */
    @PUT("user")
    User update(@Body User user);

    /**
     * delete
     * @param id    id
     * @return  void
     */
    @DELETE("user/{id}")
    Void delete(@Query("id") Long id);
}
