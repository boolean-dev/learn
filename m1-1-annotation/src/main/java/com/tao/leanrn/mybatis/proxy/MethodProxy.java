package com.tao.leanrn.mybatis.proxy;

import com.tao.leanrn.mybatis.handler.DaoOperatorHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @ClassName MethodProxy
 * @Descriiption 方法代理
 * @Author yanjiantao
 * @Date 2019/6/27 11:11
 **/
public class MethodProxy implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return DaoOperatorHandler.handle(method,args);
    }
}
