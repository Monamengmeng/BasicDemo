package com.dongdong.shop.threadtest;

/**
 * 龟兔赛跑：2000米 
 * 要求：
 *     (1)兔子每 0.1 秒 5 米的速度，每跑20米休息1秒;
 *     (2)乌龟每 0.1 秒跑 2 米，不休息；
 *     (3)其中一个跑到终点后另一个不跑了！
 * 程序设计思路：
 *     (1)创建一个Animal动物类，继承Thread，编写一个running抽象方法，重写run方法，把running方法在run方法里面调用。
 *     (2)创建Rabbit兔子类和Tortoise乌龟类，继承动物类
 *     (3)两个子类重写running方法
 *     (4)本题的第3个要求涉及到线程回调。需要在动物类创建一个回调接口，创建一个回调对象。
 *
 * @author Mona
 * @date 2020/7/2 15:53
 */
public abstract class Animal extends Thread {

    static double distance = 2000;

    public abstract void running();

    @Override
    public void run() {
        super.run();
        while (distance > 0) {
            running();
        }
    }

    // 1.在需要回调数据的地方（两个子类需要），声明一个接口
    public static interface CallToback{
        public void win();
    }

    // 2.创建接口对象
    public CallToback  calltoback;

}
