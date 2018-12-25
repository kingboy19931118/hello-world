package com.arbor.note.basic;

/**
 * @author qiaomu.wang
 * @date 2018-12-20
 */
public class OverloadWithOverride {

    public static class Father{

        void fun1() {

        }
    }

    public static class Son extends Father {

        @Override
        void fun1() {
            super.fun1();
        }
    }

    public static void main(String[] args) {
        Son son = new Son();
        son.fun1();
    }
}
