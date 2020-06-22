package com.dongdong.shop;

import java.util.HashMap;

/**
 * 懒汉式---单例模式
 *
 * @author Mona
 * @date 2020/6/12 17:10
 */
public class LazySingleton {
    private static volatile LazySingleton lazySingleton;

    private LazySingleton() {
        System.out.println(Thread.currentThread().getName() + "ok");
    }

    public static LazySingleton getInstance() {
        if(lazySingleton == null) {
            synchronized (LazySingleton.class) {
                if(lazySingleton == null) {
                    lazySingleton = new LazySingleton();
                }
            }
        }
        return lazySingleton;
    }

    //多线程并发
    public static void main(String[] args) {
        for(int i=0;i<10;i++) {
            new Thread(()->{
                LazySingleton.getInstance();
            }).start();
        }
    }

}
