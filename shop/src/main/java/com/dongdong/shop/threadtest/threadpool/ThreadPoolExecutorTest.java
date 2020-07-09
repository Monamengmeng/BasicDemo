package com.dongdong.shop.threadtest.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author Mona
 * @date 2020/7/6 20:31
 */
public class ThreadPoolExecutorTest {
    public static void main(String[] args) {
        // 创建一个定长线程池，支持定时及周期性任务执行——-----延迟执行
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        // 延迟 1秒执行   ===//输出结果为：延迟1秒执行
//        scheduledThreadPool.schedule(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("延迟1秒执行");//输出结果为：延迟1秒执行
//            }
//        } ,1, TimeUnit.SECONDS);


        /**
         *  执行结果为：
         *         延迟1秒后每3秒执行一次
         *         延迟1秒后每3秒执行一次
         *         ......
         */
        scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("延迟1秒后每3秒执行一次");
            }
        },1,3,TimeUnit.SECONDS);

    }
}
