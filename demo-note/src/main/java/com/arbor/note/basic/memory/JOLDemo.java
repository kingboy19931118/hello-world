package com.arbor.note.basic.memory;

import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * com.arbor.note.basic.memory.JOLDemo
 *
 * @author Joem
 * @date 2020-08-18
 * @since v2.0.0
 */
public class JOLDemo {

    public static class Persion extends Object {
        private boolean gender;
        private int age = 1;
        private String name;

        public Persion() {
        }
    }

    public static void main(String[] args) {
        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());

        synchronized (o) {
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }

        Persion p = new Persion();
        System.out.println(ClassLayout.parseInstance(p).toPrintable());

        synchronized (p) {
            System.out.println(ClassLayout.parseInstance(p).toPrintable());
        }

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(() -> {
            synchronized (p) {
                System.out.println(ClassLayout.parseInstance(p).toPrintable());
                try {
                    Thread.sleep(5000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executorService.submit(() -> {
            synchronized (p) {
                System.out.println(ClassLayout.parseInstance(p).toPrintable());
                try {
                    Thread.sleep(5000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executorService.shutdown();
    }

}
