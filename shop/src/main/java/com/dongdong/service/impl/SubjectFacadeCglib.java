package com.dongdong.service.impl;

import com.dongdong.service.Message;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 使用cglib动态代理
 *
 * @author Mona
 * @date 2020/6/10 16:52
 */
public class SubjectFacadeCglib implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("执行前----");
        Object o1 = methodProxy.invokeSuper(o, objects);
        System.out.println("后");

        return o1;
    }
}
