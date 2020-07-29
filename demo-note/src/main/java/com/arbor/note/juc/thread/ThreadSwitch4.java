package com.arbor.note.juc.thread;

/**
 * @author qiaomu.wang
 * @date 2018-12-24
 */
public class ThreadSwitch4 {
    static class Word {
        String s;
        public Word(String a) {
            s = a;
        }
        public void setS (String a) {
            s = a;
        }
        public String getS() {
            return s;
        }
    }
    static final int MAX_TIMES = 10;
    static int i = 0;
    static Object obj = new Object();
    static Object obj4 = new Object();
//    static Word s = new Word("A");

    static final Object obj1 = new Object();
    static final Object obj2 = new Object();
    public static void main(String[] args) throws InterruptedException {

            new Thread(() -> {
//                synchronized (obj2) {
                    do1();
//                }
            }).start();

            new Thread(() -> {
//                synchronized (obj1) {
                    do2();
//                }
            }).start();
    }

    public static synchronized void do1() {
        try {
            obj1.wait();
            System.out.println("a");
            obj2.notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static synchronized void do2() {
        try {
            obj2.wait();
            System.out.println("b");
            obj1.notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}