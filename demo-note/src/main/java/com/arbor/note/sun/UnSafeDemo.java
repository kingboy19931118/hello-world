package com.arbor.note.sun;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author qiaomu.wang
 * @date 2018-12-13
 */
public class UnSafeDemo {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafe.setAccessible(true);
        Unsafe unSafe = (Unsafe) theUnsafe.get(null);
        Long num = 100000000L;
        System.out.println(num);
        Class<Long> longClass = Long.class;
        Field value = longClass.getDeclaredField("value");
        long l = unSafe.objectFieldOffset(value);
        System.out.println(l);
        unSafe.compareAndSwapLong(num, l, 100000001L, 100L);
        System.out.println(num);
    }
}
