package com.arbor.note.proxy.cglib;

/**
 * @author qiaomu.wang
 * @date 2018-12-19
 */
public class HelloConcrete {

    static {
        System.out.println("HelloConcrete 静态代码块");
    }

    {
        System.out.println("HelloConcrete 代码块");
    }

    public HelloConcrete() {
        System.out.println("构造器执行");
    }

    public String sayHello(String string) {
        return "HelloConcrete : " + string;
    }
}
