package com.dongdong.shop;

import com.dongdong.service.Subject;
import com.dongdong.service.impl.RealSubject;
import com.dongdong.service.impl.WorkInvocationHandler;

import java.lang.reflect.Proxy;

/**
 * 代理流程
 *  1、new一个目标对象
 *  2、new一个InvocationHandler，将目标对象set进去
 *  3、通过CreatProxyedObj（wrapper）创建代理对象，强转为目标对象的接口类型即可使用，实际上生成的代理对象实现了目标接口
 *
 * @author Mona
 * @date 2020/6/9 21:21
 */
public class ProxyMain {
    public static void main(String[] args) {
//        Subject proxy = SubjectStaticFactory.getInstance();
//        proxy.dealTask("DBQueryTask");

        Subject realSubject = new RealSubject();
        Subject proxy = (Subject) Proxy.newProxyInstance(RealSubject.class.getClassLoader(),
                new Class[]{Subject.class}, new WorkInvocationHandler(realSubject));
        proxy.dealTask("ddddd");

    }
}
