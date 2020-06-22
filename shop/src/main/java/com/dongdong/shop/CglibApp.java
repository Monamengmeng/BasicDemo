package com.dongdong.shop;

import com.dongdong.service.Message;
import com.dongdong.service.impl.SubjectFacadeCglib;
import net.sf.cglib.proxy.Enhancer;

/**
 * @author Mona
 * @date 2020/6/10 17:10
 */
public class CglibApp {
    public static void main(String[] args) {
        Message target = new Message();//核心业务对象
        Enhancer enhancer = new Enhancer(); // 通过CGLIB动态代理获取代理对象的过程
        enhancer.setSuperclass(target.getClass()); // 模拟一个公共父类
        enhancer.setCallback(new SubjectFacadeCglib());//配置代理功能
        Message proxy = (Message) enhancer.create();//创建代理对象
        System.out.println(proxy.echo("cglib测试一下啊！"));

    }
}
