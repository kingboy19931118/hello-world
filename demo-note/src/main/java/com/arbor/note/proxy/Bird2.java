package com.arbor.note.proxy;

/**
 * @author qiaomu.wang
 * @date 2018-12-18
 */
public class Bird2 extends Bird {
    @Override
    public void fly() {
        long begin = System.currentTimeMillis();
        super.fly();
        long end = System.currentTimeMillis();
        System.out.println(String.format("Fly time = %d", end - begin));
    }
}
