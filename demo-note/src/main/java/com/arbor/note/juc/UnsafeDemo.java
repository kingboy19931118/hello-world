package com.arbor.note.juc;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * com.arbor.note.juc.UnsafeDemo
 *
 * @author Joem
 * @date 2020-01-15
 * @since v2.0.0
 */
public class UnsafeDemo {

    public static Unsafe getUnsafeInstance() throws NoSuchFieldException, IllegalAccessException {
        Field unsafeStaticField = Unsafe.class.getDeclaredField("theUnsafe");
        unsafeStaticField.setAccessible(true);
        return (Unsafe) unsafeStaticField.get(Unsafe.class);
    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        modifyArray();

        instanceWithOutConstructor();
    }

    private static void instanceWithOutConstructor() throws NoSuchFieldException, IllegalAccessException,
            InstantiationException {
        Unsafe u = getUnsafeInstance();
        Test test = (Test) u.allocateInstance(Test.class);
        test.speek();
    }

    private static void modifyArray() throws NoSuchFieldException, IllegalAccessException {
        Unsafe unsafeInstance = getUnsafeInstance();
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int b = unsafeInstance.arrayBaseOffset(int[].class);
        int s = unsafeInstance.arrayIndexScale(int[].class);

        unsafeInstance.putInt(arr, (long)b + s * 9, 1);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(unsafeInstance.getInt(arr, (long) b + s * i) + "|");
        }
    }
}

class Test {

    private int i;

    private Test() {
        System.out.println("test constructor execute !");
    }

    public void speek() {
        System.out.println(Thread.currentThread().getName() + "----------speek!");
    }
}