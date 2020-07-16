package com.arbor.note.basic;

import java.util.Queue;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * com.arbor.note.basic.WaitNotifyAllDemo
 *
 * @author Joem
 * @date 2020-06-19
 * @since v2.0.0
 */
public class WaitNotifyAllDemo {

    public static final Queue<Object> quere = new LinkedBlockingDeque<>();
    static int size = 10;


    public static void main(String[] args) {
        Runnable a = () -> {
            while (true) {
                synchronized (quere) {
                    if (quere.size() <= size) {
                        quere.add(UUID.randomUUID().toString());
                    }
                    try {
                        quere.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Runnable b = () -> {

        };

        new Thread(a).start();
        new Thread(b).start();
    }

    public class A implements Runnable {
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

        }
    }


}
