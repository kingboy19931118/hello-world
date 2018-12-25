package com.arbor.note.proxy.cglib;

/**
 * @author qiaomu.wang
 * @date 2018-12-19
 */
public class Hello extends HelloConcrete{

    @Override
    public String sayHello(String string) {
        return "hello :" + string;
    }
}
