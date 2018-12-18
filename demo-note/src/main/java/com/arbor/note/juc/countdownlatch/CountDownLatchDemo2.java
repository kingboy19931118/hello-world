package com.arbor.note.juc.countdownlatch;

import org.springframework.scheduling.concurrent.ThreadPoolExecutorFactoryBean;

import java.util.concurrent.*;

/**
 * @author qiaomu.wang
 * @date 2018-12-13
 */
public class CountDownLatchDemo2 {

    private static BlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(50);
    private static ThreadFactory threadFactory = new ThreadPoolExecutorFactoryBean();

    private static ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 20,
            15, TimeUnit.SECONDS, queue, threadFactory);
    private static ExecutorService executorService = Executors.newFixedThreadPool(3, threadFactory);

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch count = new CountDownLatch(3);
        executor.allowCoreThreadTimeOut(true);
        System.out.println("begin");
        executor.execute(() -> System.out.println(fun1(count)));
        System.out.println("config t1");
        executor.execute(() -> {
            try {
                Thread.sleep(5000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(fun2(count));
        });
        System.out.println("config t2");
        executor.execute(() -> {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(fun3(count));
        });
        System.out.println("config t3");
        System.out.println("wait 3 thread done!");
        count.await();
        System.out.println("over");
        System.out.println(count.getCount());
    }

    public static String fun1(CountDownLatch count) {
        count.countDown();
        return "fun1";
    }

    public static String fun2(CountDownLatch count) {
        count.countDown();
        return "fun2";
    }

    public static String fun3(CountDownLatch count) {
        count.countDown();
        return "fun3";
    }


}
