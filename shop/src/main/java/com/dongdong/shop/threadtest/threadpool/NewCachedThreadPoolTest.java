package com.dongdong.shop.threadtest.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池为无限大，当执行当前任务时上一个任务已经完成，会复用执行上一个任务的线程，而不用每次新建线程
 *
 * pool-1-thread-1正在执行
 *  * pool-1-thread-1正在执行
 *  * pool-1-thread-1正在执行
 *  * pool-1-thread-1正在执行
 *  * pool-1-thread-1正在执行
 *  * pool-1-thread-1正在执行
 *  * pool-1-thread-1正在执行
 *  * pool-1-thread-1正在执行
 *  * pool-1-thread-1正在执行
 *  * pool-1-thread-1正在执行
 *
 * @author Mona
 * @date 2020/7/3 17:29
 */
public class NewCachedThreadPoolTest {
    public static void main(String[] args) {
        // 创建一个可缓存线程池
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0;i < 10; i++) {
            try {
                // sleep可以明显看到使用的是线程池里面以前的线程，没有创建新的线程
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    // 打印正在执行的缓存线程信息
                    System.out.println(Thread.currentThread().getName() + "正在执行");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

        }






    }
}
