package com.dongdong.shop.threadtest;

/**
 * @author Mona
 * @date 2020/7/2 15:54
 */
public class AnimalRabbit extends Animal {

    public AnimalRabbit() {
        setName("兔子");
    }

    @Override
    public void running() {
        // 兔子速度
        int dis = 5;
        distance -= dis;
        System.out.println("兔子跑了" + dis + "米，距离终点还有" + distance + "米");
        if (distance <= 0) {
            distance = 0;
            System.out.println("兔子获得了胜利");
            // 给回调函数赋值，让乌龟不要再跑了
            if (calltoback != null) {
                calltoback.win();
            }
        }
        try {
            if ((2000 - distance)%20 == 0) {        // 每20米休息一次,休息时间是1秒
                sleep(1000);
            } else {                                // 每0.1秒跑5米
                sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
