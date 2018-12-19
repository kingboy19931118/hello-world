package com.arbor.note.proxy;

/**
 * @author qiaomu.wang
 * @date 2018-12-18
 */
public class BirdLogProxy implements Flyable {

    private Flyable flyable;

    public BirdLogProxy(Flyable flyable) {
        this.flyable = flyable;
    }

    @Override
    public void fly() {

        System.out.println("Bird fly begin");

        flyable.fly();

        System.out.println("Bird fly end");

    }
}
