package com.dongdong.shop.threadtest.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Executors.newSingleThreadExecutor()：
 * 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
 *
 * 执行结果为：
 *  pool-1-thread-1正在被执行，打印的值是:0
 * pool-1-thread-1正在被执行，打印的值是:1
 * pool-1-thread-1正在被执行，打印的值是:2
 * pool-1-thread-1正在被执行，打印的值是:3
 * pool-1-thread-1正在被执行，打印的值是:4
 * pool-1-thread-1正在被执行，打印的值是:5
 * pool-1-thread-1正在被执行，打印的值是:6
 * pool-1-thread-1正在被执行，打印的值是:7
 * pool-1-thread-1正在被执行，打印的值是:8
 * pool-1-thread-1正在被执行，打印的值是:9
 *
 * @author Mona
 * @date 2020/7/6 20:42
 */
public class TestThreadPoolExecutor {
    public static void main(String[] args) {
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            singleThreadExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        // 结果依次输出，相当于顺序执行各个任务
                        System.out.println(Thread.currentThread().getName() + "正在被执行，打印的值是:" + index);
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
