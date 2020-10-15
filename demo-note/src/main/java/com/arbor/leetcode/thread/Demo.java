package com.arbor.leetcode.thread;

/**
 * com.arbor.leetcode.thread.Demo
 *
 * https://leetcode-cn.com/problems/print-foobar-alternately/
 *
 * @author Joem
 * @date 2020-10-13
 * @since v2.0.0
 */
class Demo {
    private int n;
    private volatile int flag = 0;
    private static final Object lock = new Object();

    public Demo(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (lock) {
                if (flag == 1) {
                    lock.wait();
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                flag = 1;
                lock.notifyAll();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            synchronized (lock) {
                if (flag == 0) {
                    lock.wait();
                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                flag = 0;
                lock.notifyAll();
            }
        }
    }
}