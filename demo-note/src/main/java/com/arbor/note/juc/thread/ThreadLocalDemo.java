package com.arbor.note.juc.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

/**
 * com.arbor.note.juc.thread.ThreadLocalDemo
 *
 * @author Joem
 * @date 2020-05-20
 * @since v2.0.0
 */
public class ThreadLocalDemo {

    private static transient Logger logger = LoggerFactory.getLogger(ThreadLocalDemo.class);

    public static void main(String[] args) throws InterruptedException {
        MDC.put("traceId", "1234567");
        InheritableThreadLocal<String> local = new InheritableThreadLocal<>();
        System.out.println(Thread.currentThread().getName() + " local.get:" + local.get());
        local.set("abc");
        System.out.println(Thread.currentThread().getName() + " local.get2:" + local.get());
        new MyThread(local).start();
        Thread.sleep(1000L);
        System.out.println(Thread.currentThread().getName() + " local.get3:" + local.get());
    }

    static class MyThread extends Thread {

        InheritableThreadLocal<String> local;

        public MyThread(InheritableThreadLocal<String> local) {
            this.local = local;
        }

        /**
         * When an object implementing interface <code>Runnable</code> is used
         * to create a thread, starting the thread causes the object's
         * <code>run</code> method to be called in that separately executing
         * thread.
         * <p>
         * The general contract of the method <code>run</code> is that it may
         * take any action whatsoever.
         *
         * @see Thread#run()
         */
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " local.get:" + this.local.get());
            this.local.set("child local");
            System.out.println(Thread.currentThread().getName() + " local.get2:" + this.local.get());
        }
    }

}
