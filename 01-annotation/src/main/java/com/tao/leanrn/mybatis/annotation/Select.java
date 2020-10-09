package com.tao.leanrn.mybatis.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName Delete
 * @Descriiption 查询注解
 * @Author yanjiantao
 * @Date 2019/6/27 11:03
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Select {
    public String value();
}
