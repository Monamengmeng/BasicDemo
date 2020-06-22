package com.dongdong.service.impl;

import com.dongdong.service.Subject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理就是要生成一个包装类对象，由于代理的对象是动态的，所以叫动态代理
 * 由于我们需要增强，这个增强是需要留给开发人员开发代码的，因此代理类不能直接包含被代理对象，而是一个InvocationHandler，
 * 该InvocationHandler包含被代理对象，并负责分发请求给被代理对象，分发前后均可以做增强。
 * 从原理可以看出，JDK动态代理是“对象”的代理。
 *
 * @author Mona
 * @date 2020/6/9 21:38
 */
public class WorkInvocationHandler implements InvocationHandler {
    //目标类，即被代理类
    private Subject realSubject;

    public WorkInvocationHandler(Subject realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        long stime = System.currentTimeMillis();
        Object invoke = method.invoke(realSubject, args);
        long ftime = System.currentTimeMillis();
        System.out.println("执行任务耗时"+(ftime - stime)+"毫秒");

        return invoke;
    }
}
