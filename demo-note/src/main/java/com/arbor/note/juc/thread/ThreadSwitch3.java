package com.arbor.note.juc.thread;

/**
 * @author qiaomu.wang
 * @date 2018-12-24
 */
public class ThreadSwitch3 {
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
//    static Word s = new Word("A");
    public static void main(String[] args) throws InterruptedException {
        //A线程
        Thread t1 = new Thread(() -> {
            while (i < MAX_TIMES) {
                synchronized (obj) {
                        try {
                            obj.notify();
                            System.out.println(Thread.currentThread().getName() + "____t1");
                            i++;
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                }
            }
        });
        //B线程
        Thread t2 = new Thread(() -> {
            while (i < MAX_TIMES) {
                synchronized (obj) {
                        try {
                            obj.wait();
                            System.out.println(Thread.currentThread().getName() + "_______t2");
                            i++;
                            obj.notify();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                }
            }
        });
        t1.start();
        t2.start();
    }
}