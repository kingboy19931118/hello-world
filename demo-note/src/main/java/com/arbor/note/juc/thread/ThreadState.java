package com.arbor.note.juc.thread;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 线程运行状态
 *
 * @author qiaomu.wang
 * @date 2018-12-18
 */
public class ThreadState {

    public static void main(String[] args) {
        Runnable waiting = new TimeWaiting();
//        waiting.run();

        Long num1 = 500L;
        Integer num2 = 500;
        System.out.println(num1.hashCode());
        System.out.println(num2.hashCode());
        Map<Object, Object> map = Maps.newHashMap();
        map.put(num1, "long");
        map.put(num2, "integer");

        System.out.println(map.get(num1));
        System.out.println(map.get(num2));

    }

    static class TimeWaiting implements Runnable {
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
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Waiting implements Runnable {
        @Override
        public void run() {
            while (true) {
                synchronized (Waiting.class) {
                    try {
                        Waiting.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
