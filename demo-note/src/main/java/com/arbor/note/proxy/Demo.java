package com.arbor.note.proxy;

/**
 * @author qiaomu.wang
 * @date 2018-12-18
 */
public class Demo {

    public static void main(String[] args) {

        Bird bird = new Bird();
        Flyable birdLogProxy = new BirdLogProxy(bird);
        Flyable birdTimeProxy = new BirdTimeProxy(birdLogProxy);

        birdTimeProxy.fly();


        System.out.println("============================================");

        Bird bird2 = new Bird();
        Flyable birdTimeProxy2 = new BirdTimeProxy(bird2);
        Flyable birdLogProxy2 = new BirdLogProxy(birdTimeProxy2);

        birdLogProxy2.fly();
    }
}
