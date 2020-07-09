package com.dongdong.shop.threadtest;

/**
 * @author Mona
 * @date 2020/7/2 16:59
 */
public class AnimalLetOneStop implements Animal.CallToback {
    //动物对象
    Animal animal;

    // 获取动物对象，可以传入兔子或乌龟的实例
    public AnimalLetOneStop(Animal animal) {
        this.animal = animal;
    }

    // 让动物的线程停止
    @Override
    public void win() {
        // 线程停止
        animal.stop();
    }
}
