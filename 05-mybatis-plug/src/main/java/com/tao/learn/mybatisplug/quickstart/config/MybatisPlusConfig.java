package com.tao.learn.mybatisplug.quickstart.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author 谛听
 * @className MybatisPlusConfig
 * @descriiption Mybatis配置信息
 * @date 2019/11/7 17:56
 **/

@Configuration
public class MybatisPlusConfig {

   /* @Bean
    @Profile({"dev","test"})// 设置 dev test 环境开启
    public PerformanceInterceptor performanceInterceptor() {
        return new PerformanceInterceptor();
    }*/
}