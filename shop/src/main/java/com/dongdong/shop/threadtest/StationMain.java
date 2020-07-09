package com.dongdong.shop.threadtest;

/**
 * java多线程同步锁的使用
 * 示例：三个售票窗口同时出售10张票
 *
 * https://blog.csdn.net/qq_34996727/article/details/80416277
 *
 * 输出结果为：
 * 窗口1卖出了第20张票!
 * 窗口2卖出了第19张票!
 * 窗口3卖出了第18张票!
 * 窗口3卖出了第17张票!
 * 窗口1卖出了第16张票!
 * 窗口2卖出了第15张票!
 * 窗口2卖出了第14张票!
 * 窗口3卖出了第13张票!
 * 窗口1卖出了第12张票!
 * 窗口3卖出了第11张票!
 * 窗口1卖出了第10张票!
 * 窗口2卖出了第9张票!
 * 窗口2卖出了第8张票!
 * 窗口1卖出了第7张票!
 * 窗口3卖出了第6张票!
 * 窗口1卖出了第5张票!
 * 窗口3卖出了第4张票!
 * 窗口2卖出了第3张票!
 * 窗口3卖出了第2张票!
 * 窗口1卖出了第1张票!
 *
 * @author Mona
 * @date 2020/7/1 21:46
 */
public class StationMain {
    public static void main(String[] args) {
        // 实例化站台对象，并为每一个站台取名字
        StationThread thread1 = new StationThread("窗口1");
        StationThread thread2 = new StationThread("窗口2");
        StationThread thread3 = new StationThread("窗口3");
        // 让每一个站台对象各自开始工作
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
