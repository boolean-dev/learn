package com.tao.retrofit.client;

import com.tao.retrofit.api.entity.User;
import com.tao.retrofit.api.service.UserService;
import com.tao.retrofit.client.adapter.BodyCallAdapterFactory;
import lombok.extern.slf4j.Slf4j;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;

/**
 * Retrofit 测试方法
 *
 * @author Jiantao Yan
 * @title: Retrofit
 * @date 2021/1/28 16:57
 */
@Slf4j
public class RetrofitMain {

    public static void main(String[] args) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://127.0.0.1:9100/")
                .addCallAdapterFactory(new BodyCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        UserService userService = retrofit.create(UserService.class);

        save(userService);
        update(userService);
        list(userService);
        get(userService);
        delete(userService);
    }

    private static void save(UserService userService) {
        log.info("------->create user begin");
        User user = new User("booleandev", 24);
        log.info("------->create user={}", user);
        User result = userService.save(user);
        log.info("------->create result={}", result);
        log.info("------->create user end");
    }

    private static void update(UserService userService) {
        log.info("------->update user begin");
        User user = new User(123L,"booleandev", 24);
        log.info("------->update user={}", user);
        User result = userService.update(user);
        log.info("------->update result={}", result);
        log.info("------->update user end");
    }

    private static void list(UserService userService) {
        log.info("------->list user begin");
        List<User> result = userService.list();
        result.forEach(user -> log.info("------->list result={}", user));
        log.info("------->list user end");
    }

    private static void get(UserService userService) {
        log.info("------->get user begin");
        User result = userService.get(123L);
        log.info("------->get result={}", result);
        log.info("------->get user end");
    }

    private static void delete(UserService userService) {
        log.info("------->delete user begin");
        userService.delete(123L);
        log.info("------->delete user end");
    }


}
