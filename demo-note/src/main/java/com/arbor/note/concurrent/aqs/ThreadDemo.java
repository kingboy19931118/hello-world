package com.arbor.note.concurrent.aqs;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * com.arbor.note.concurrent.aqs.ThreadDemo
 *
 * @author Joem
 * @date 2020-09-18
 * @since v2.0.0
 */
public class ThreadDemo {

    private static ExclusiveDemo lock = new ExclusiveDemo();
    private static ReentrantLock reentrantLock = new ReentrantLock(false);

    public static void main(String[] args) throws InterruptedException {


        reentrantLock.lock();
        reentrantLock.lock();

        new Thread(() -> {
            boolean b = lock.tryLock();
            System.out.println(Thread.currentThread() + "\t tryLock" + b);
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
            }
            System.out.println(Thread.currentThread() + "\t execute end");
//            lock.unlock();
        }).start();

        Thread t2 = new Thread(() -> {
            lock.lock();
            System.out.println(Thread.currentThread() + "\t execute end");
        });
        t2.setDaemon(true);
        t2.start();

        System.out.println("main doing");
        Thread.sleep(4000L);
        System.out.println("main end");
        t2.interrupt();
        boolean alive = t2.isAlive();
        System.out.println("t2.isAlive:" + alive);

    }
}
