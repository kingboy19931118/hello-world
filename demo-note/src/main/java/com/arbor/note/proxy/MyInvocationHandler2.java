package com.arbor.note.proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author qiaomu.wang
 * @date 2018-12-19
 */
public class MyInvocationHandler2 implements java.lang.reflect.InvocationHandler {
    private Flyable bird;

    public MyInvocationHandler2(Bird bird) {
        this.bird = bird;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        try {
            return method.invoke(bird, args);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }
}
