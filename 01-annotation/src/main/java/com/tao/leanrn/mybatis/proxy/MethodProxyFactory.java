package com.tao.leanrn.mybatis.proxy;

import java.lang.reflect.Proxy;

/**
 * @ClassName MethodProxyFactory
 * @Descriiption 代理工厂类
 * @Author yanjiantao
 * @Date 2019/6/28 15:40
 **/
public class MethodProxyFactory {

    @SuppressWarnings("unchecked")
    public static <T> T getBean(Class<T> clazz) {
        final MethodProxy methodProxy = new MethodProxy();
        return (T) Proxy.newProxyInstance(
                Thread.currentThread().getContextClassLoader(),
                new Class[]{clazz},
                methodProxy
        );
    }
}
