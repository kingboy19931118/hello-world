package com.arbor.note.juc.thread;

import org.junit.Test;

/**
 * @author qiaomu.wang
 * @date 2018-12-24
 */
public class ThreadSwitch {
    public static boolean FLAG = false;

    public static class ThreadA implements Runnable {
        private Object obj;
        private int i = 1;
        private boolean s;

        public ThreadA(int i, Object obj, boolean s) {
            this.i = i;
            this.obj = obj;
            this.s = s;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (obj) {
                    if (FLAG == s) {
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println(i);
                        i = i + 2;
                        FLAG = !FLAG;
                        try {
                            obj.notifyAll();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
//            }
        }
    }

    @Test
    public void test1() {
        final Object lock = new Object();
        ThreadA threadA = new ThreadA(1, lock, true);
        ThreadA threadB = new ThreadA(2, lock, false);
        Thread t1 = new Thread(threadA, "线程1");
        Thread t2 = new Thread(threadB, "线程2");

        t1.start();
        t2.start();
    }


    public static void main(String[] args) throws InterruptedException {
        final Object lock = new Object();
        ThreadA threadA = new ThreadA(1, lock, true);
        ThreadA threadB = new ThreadA(2, lock, false);
        Thread t1 = new Thread(threadA, "线程1");
        Thread t2 = new Thread(threadB, "线程2");

        t1.start();
        t2.start();
    }
}
