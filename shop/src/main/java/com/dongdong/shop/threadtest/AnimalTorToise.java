package com.dongdong.shop.threadtest;

/**
 * @author Mona
 * @date 2020/7/2 15:55
 */
public class AnimalTorToise extends Animal {

    public AnimalTorToise() {
        setName("乌龟");  // Thread的方法，给线程赋值名字
    }

    // 重写running方法，编写乌龟的奔跑操作
    @Override
    public void running() {
        // 乌龟速度
        int dis = 2;
        distance -= dis;
        System.out.println("乌龟跑了" + dis + "米，距离终点还有" + distance + "米");
        if (distance <= 0) {
            distance = 0;
            System.out.println("乌龟取得了胜利");
            // 让兔子不要再跑了
            if (calltoback != null) {
                calltoback.win();
            }
        }
        try {
            sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
