package com.dongdong.shop.threadtest;

/**
 * 多线程实例
 *
 * 三个售票窗口同时出售20张票
 * 程序分析：
 *     (1)票数要使用同一个静态值
 *     (2)为保证不会出现卖出同一个票数，要java多线程同步锁。
 * 设计思路：
 *     (1)创建一个站台类Station，继承Thread，重写run方法，在run方法里面执行售票操作！售票要使用同步锁：即有一个站台卖这张票时，其他站台要等这张票卖完！
 *     (2)创建主方法调用类
 * （一）创建一个站台类，继承Thread
 *
 * @author Mona
 * @date 2020/7/1 21:35
 */
public class StationThread extends Thread {
    // 通过构造方法给线程名字赋值
    public StationThread(String name) {
        // 给线程名字赋值
        super(name);
    }

    // 为了保持票数的一致，票数要静态
    static int ticket = 20;
    // 创建一个静态钥匙, 值是任意的
    static Object key = "key";

    // 重写run方法，实现买票操作
    @Override
    public void run() {
        while (ticket > 0) {
            // 这个很重要，必须使用一个锁，
            synchronized (key) {
                // 进去的人会把钥匙拿在手上，出来后才把钥匙拿让出来
                if (ticket > 0) {
                    System.out.println(getName() + "卖出了第" + ticket + "张票!");
                    ticket--;
                } else {
                    System.out.println("票卖完了!");
                }
            }
            try {
                // 休息一秒
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
