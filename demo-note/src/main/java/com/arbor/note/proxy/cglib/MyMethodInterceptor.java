package com.arbor.note.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author qiaomu.wang
 * @date 2018-12-19
 */
public class MyMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("You said:" + Arrays.toString(objects));
        //  输出此会调用 final toString 方法
//        System.out.println(o);
        System.out.println(o.getClass());
        System.out.println(method.getName());
        System.out.println(methodProxy.getSuperName());
//        Enhancer enhancer = new Enhancer();
//        enhancer.setSuperclass(HelloConcrete.class);
//        enhancer.setCallback(new MyMethodInterceptor());
//        Object o1 = enhancer.create();
        return methodProxy.invokeSuper(o, objects);
//        return methodProxy.invoke(o, objects);
    }
}
