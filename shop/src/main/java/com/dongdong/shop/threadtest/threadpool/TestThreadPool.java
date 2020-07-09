package com.dongdong.shop.threadtest.threadpool;

/**
 * 测试线程池
 *
 * 输出结果：
 * 任务 1 完成
 * 任务 2 完成
 * 任务 3 完成
 * 任务 4 完成
 * 任务 5 完成
 * 任务 6 完成
 *
 * 分析：由于并没有任务接口，传入的可以是自定义的任何任务，
 * 所以线程池并不能准确的判断该任务是否真正的已经完成（真正完成该任务是这个任务的run方法执行完毕），
 * 只能知道该任务已经出了任务队列，正在执行或者已经完成
 *
 * @author Mona
 * @date 2020/7/7 17:17
 */
public class TestThreadPool {
    public static void main(String[] args) {
        // 创建3个线程的线程池
        ThreadPool t = ThreadPool.getThreadPool(3);
        t.execute(new Runnable[] { new Task(), new Task(), new Task() });
        t.execute(new Runnable[] { new Task(), new Task(), new Task() });
        System.out.println(t);
        t.destroy();// 所有线程都执行完成才destory
        System.out.println(t);
    }

    // 任务类
    static class Task implements Runnable {
        private static volatile int i = 1;

        @Override
        public void run() {// 执行任务
            System.out.println("任务 " + (i++) + " 完成");
        }
    }
}
