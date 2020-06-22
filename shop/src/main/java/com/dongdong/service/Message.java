package com.dongdong.service;

/**
 * 测试动态代理cglib-----不需要使用接口
 *
 * @author Mona
 * @date 2020/6/10 18:52
 */
public class Message {//不需要使用到接口
    public String echo(String msg) {
        return "[echo] " + msg;
    }
}
