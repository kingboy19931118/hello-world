package com.arbor.note.juc.thread;

/**
 * @author qiaomu.wang
 * @date 2018-12-24
 */
public class ThreadSwitch2{
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
    static Word s = new Word("A");
    public static void main(String[] args) {
        //A线程
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (i < MAX_TIMES) {
                    synchronized (s) {
                        if (s.getS().equals("B")) {
                            try {
                                s.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } else {
                            System.out.println(Thread.currentThread().getName() + "____" + s.getS());
                            s.setS("B");
                            i++;
                            s.notify();
                        }
                    }
                }
            }
        });
        //B线程
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (i < MAX_TIMES) {
                    synchronized (s) {
                        if (s.getS().equals("A")) {
                            try {
                                s.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } else {
                            System.out.println(Thread.currentThread().getName() + "_______" + s.getS());
                            s.setS("A");
                            i++;
                            s.notify();
                        }
                    }
                }
            }
        });
        t1.start();
        t2.start();
    }
}