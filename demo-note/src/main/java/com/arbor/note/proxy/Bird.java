package com.arbor.note.proxy;

import java.util.Random;

/**
 * @author qiaomu.wang
 * @date 2018-12-18
 */
public class Bird implements Flyable {
    @Override
    public void fly() {
        System.out.println("Bird is flying...");
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
