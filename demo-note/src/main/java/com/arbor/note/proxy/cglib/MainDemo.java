package com.arbor.note.proxy.cglib;

import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;

/**
 * @author qiaomu.wang
 * @date 2018-12-19
 */
public class MainDemo {

    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "C:\\classes");
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(HelloConcrete.class);
        enhancer.setCallback(new MyMethodInterceptor());

        HelloConcrete helloConcrete = (HelloConcrete) enhancer.create();
        System.out.println("动态代理生成对象");
//        helloConcrete.sayHello("cglib nbnbnb!!!");
        System.out.println(helloConcrete.sayHello("cglib nbnbnb!!!"));
    }
}
