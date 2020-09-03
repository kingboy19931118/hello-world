package com.arbor.note.juc.thread;

/**
 * join  将多线程变更为顺序执行。
 * @link https://juejin.im/post/5d70ae4e5188252e961921e1?utm_source=gold_browser_extension
 */
public class JoinDemo {

    public static void main(String[] args) throws InterruptedException {
        Join j1 = new Join();
        Join j2 = new Join();
        Join j3 = new Join();
        System.out.println("main doing1");
        j1.start();
        System.out.println("main doing11");
        Thread.sleep(1000L);
        j1.join();
        System.out.println("main doing2");
        j2.start();
        System.out.println("main doing22");
        j2.join();
        System.out.println("main doing3");
        j3.start();
        System.out.println("main doing33");
        j3.join();
        System.out.println("main doing4");
        System.out.println("main doing44");
    }


}

class Join extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 2; i++) {
            try {
                Thread.sleep(500L);
                System.out.println("Current Thread :  " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}