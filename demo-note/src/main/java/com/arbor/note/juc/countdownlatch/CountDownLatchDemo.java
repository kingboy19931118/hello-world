package com.arbor.note.juc.countdownlatch;

import java.util.concurrent.CountDownLatch;

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
    }

    static class Driver {
        void main() throws InterruptedException {
            CountDownLatch startSignal = new CountDownLatch(1);
            CountDownLatch doneSignal = new CountDownLatch(5);

            // create and start threads
            for (int i = 0; i < 5; ++i) {
                new Thread(new Worker(startSignal, doneSignal)).start();
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
                doneSignal.countDown();
            } catch (InterruptedException ex) {
                System.out.println("系统异常");
            }
        }


        void doWork() {
            System.out.println("工人清理");
        }

    }
}