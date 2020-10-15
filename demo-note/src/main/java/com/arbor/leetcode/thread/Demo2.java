package com.arbor.leetcode.thread;

import java.util.concurrent.Semaphore;

/**
 * com.arbor.leetcode.thread.Demo
 *
 * https://leetcode-cn.com/problems/print-foobar-alternately/
 *
 * @author Joem
 * @date 2020-10-13
 * @since v2.0.0
 */
class Demo2 {
    private int n;
    Semaphore s1 = new Semaphore(1);
    Semaphore s2 = new Semaphore(0);

    public Demo2(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            s1.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            s2.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            s2.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            s1.release();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(0);
        semaphore.release(5);
        semaphore.acquire(2);
        System.out.println(semaphore.getQueueLength());
        System.out.println(semaphore.availablePermits());
    }
}