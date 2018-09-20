package com.arbor.note.juc.countdownlatch;

import org.springframework.scheduling.concurrent.ThreadPoolExecutorFactoryBean;

import java.util.concurrent.*;

/**
 * 同步工具类 countDownList
 *
 * @author qiaomu.wang
 * @link http://www.importnew.com/15731.html
 * @date 2018-08-20
 * @since 1.5
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        Driver driver = new Driver();
        System.out.println("--------------begin----------------");
        driver.main();
        System.out.println("---------------end-----------------");
//        driver = null;
//        System.gc();
    }

    static class Driver {
        BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(50);
        ThreadFactory threadFactory = new ThreadPoolExecutorFactoryBean();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 20, 10, TimeUnit.SECONDS, queue, threadFactory);

//        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2);

        {
            executor.setKeepAliveTime(10, TimeUnit.SECONDS);
            executor.allowCoreThreadTimeOut(true);
        }

        void main() throws InterruptedException {
            CountDownLatch startSignal = new CountDownLatch(1);
            CountDownLatch doneSignal = new CountDownLatch(5);

            // create and start threads
            for (int i = 0; i < 5; ++i) {
                executor.execute(new Worker(startSignal, doneSignal));
//                new Thread(new Worker(startSignal, doneSignal)).start();
            }

            // don't let run yet
            doSomethingElse();
            // let all threads proceed
            startSignal.countDown();
            doSomethingElse();
            // wait for all to finish
            doneSignal.await();
        }

        private void doSomethingElse() {
            System.out.println("等待");
        }

    }


    static class Worker implements Runnable {

        private final CountDownLatch startSignal;

        private final CountDownLatch doneSignal;


        Worker(CountDownLatch startSignal, CountDownLatch doneSignal) {
            this.startSignal = startSignal;
            this.doneSignal = doneSignal;
        }


        @Override
        public void run() {
            try {
                startSignal.await();
                doWork();
            } catch (InterruptedException ex) {
                System.out.println("系统异常");
            } finally {
                doneSignal.countDown();
            }
        }


        void doWork() {
            System.out.println("工人清理");
        }

    }
}