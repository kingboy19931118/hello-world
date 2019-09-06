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
        j1.start();
        j1.join();
        j2.start();
        j2.join();
        j3.start();
        j3.join();
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