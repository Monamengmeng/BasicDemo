package com.dongdong.shop.threadtest;

/**
 * 线程示例总结
 *
 *     （1）代码块锁是一个防止数据发生错误的一个重要手段；
 *     （2）对象的统一性是非常重要的，这要想到对象的传入问题，
 *     要操作的对象只能new一次，其他的操作都是对这个传入的对象进行的，才能保证数据一致性，完整性和正确性。
 *
 *
 *    运行结果：
 *    ......
 * 乌龟跑了2米，距离终点还有12.0米
 * 乌龟跑了2米，距离终点还有10.0米
 * 乌龟跑了2米，距离终点还有8.0米
 * 乌龟跑了2米，距离终点还有6.0米
 * 乌龟跑了2米，距离终点还有4.0米
 * 乌龟跑了2米，距离终点还有2.0米
 * 乌龟跑了2米，距离终点还有0.0米
 * 乌龟取得了胜利
 *
 * @author Mona
 * @date 2020/7/2 15:55
 */
public class AnimalMain {
    public static void main(String[] args) {
        // 实例化兔子和乌龟
        AnimalTorToise torToise = new AnimalTorToise();
        AnimalRabbit rabbit = new AnimalRabbit();
        // 回调方法的使用，谁先调用calltoback方法，另一个就不跑了
        AnimalLetOneStop letOneStop1 = new AnimalLetOneStop(torToise);
        // 让兔子的回调方法里面存在乌龟对象的值，可以把乌龟stop
        rabbit.calltoback = letOneStop1;
        AnimalLetOneStop letOneStop2 = new AnimalLetOneStop(rabbit);
        // 让乌龟的回调方法里面存在兔子对象的值，可以把兔子stop
        torToise.calltoback = letOneStop2;
        // 开始跑
        torToise.start();
        rabbit.start();
    }
}
