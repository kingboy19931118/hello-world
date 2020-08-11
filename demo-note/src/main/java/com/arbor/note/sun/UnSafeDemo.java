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
        System.out.println("未处理的原始数据：" + num);
        Class<Long> longClass = Long.class;
        Field value = longClass.getDeclaredField("value");
        long l = unSafe.objectFieldOffset(value);
        System.out.println("当前对象类型的偏移量: " + l);
        unSafe.compareAndSwapLong(num, l, 100000000L, 100L);
        System.out.println("compareAndSwapLong后的结果： " + num);

        Long longValue = 123L;
        Field theUnsafe1 = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafe1.setAccessible(true);
        Unsafe unsafe = (Unsafe) theUnsafe1.get(null);
        unsafe.compareAndSwapLong(longValue, 16L, 123L, 33L);
        System.out.println(longValue);
    }
}
