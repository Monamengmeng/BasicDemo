package com.dongdong.service.impl;

import com.dongdong.service.Subject;

/**
 * 生成静态代理类工厂
 *
 * @author Mona
 * @date 2020/6/9 19:11
 */
public class SubjectStaticFactory {
    //客户类调用此工厂方法获得代理对象。
    //对客户类来说，其并不知道返回的是代理类对象还是委托类对象。
    public static Subject getInstance() {

        return new ProxySubject(new RealSubject());
    }
}
