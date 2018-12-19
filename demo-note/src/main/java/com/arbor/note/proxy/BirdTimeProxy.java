package com.arbor.note.proxy;

/**
 * @author qiaomu.wang
 * @date 2018-12-18
 */
public class BirdTimeProxy implements Flyable {

    private Flyable flyable;

    public BirdTimeProxy(Flyable flyable) {
        this.flyable = flyable;
    }

    @Override
    public void fly() {
        long begin = System.currentTimeMillis();
        flyable.fly();
        long end = System.currentTimeMillis();
        System.out.println(String.format("Fly time = %d", end - begin));
    }
}
