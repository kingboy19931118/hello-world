package com.arbor.note.basic.memory;

import java.util.ArrayList;
import java.util.List;

/**
 * com.arbor.note.basic.memory.EscapeAnalyzeDemo
 * 逃逸分析， 栈上分配、标量替换、同步消除
 *
 * @author Joem
 * @date 2020-09-03
 * @since v2.0.0
 */
public class EscapeAnalyzeDemo {

    private static Persion persion = new Persion();

    public static class Persion extends Object {
        private boolean gender;
        private int age = 1;
        private String name;
        private int a1;
        private int a2;
        private int a3;
        private int a4;
        private int a5;
        private int a6;
        private int a7;
        private int a8;
        private int a9;
        private int a10;
        private int a11;
        private int a12;
        private int a13;
        private int a14;
        private int a15;
        private int a16;
        private int a17;
        private int a27;
        private int a28;
        private int a29;
        private int a210;
        private List<String> str;



        public Persion() {
        }
    }

    public synchronized void createPersion() {
        new Persion();
    }

    public Persion createPersionWithOutSynchronized() {
        return new Persion();
    }

    public String createString(String ... values){
        StringBuffer stringBuffer = new StringBuffer();
        for (String string : values) {
            stringBuffer.append(string+" ");
        }
        return stringBuffer.toString();
    }

    public int num = 0;
    public Persion add() {
        Persion persion = createPersionWithOutSynchronized();
        num += persion.age;
        return persion;
    }


    public static void main(String[] args) {
        List<Persion> list = new ArrayList<>();
        EscapeAnalyzeDemo jolDemo = new EscapeAnalyzeDemo();
        long time = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
//            jolDemo.createString("Hello", "World");
            jolDemo.add();
        }
        System.out.println(jolDemo.num);

        System.out.println(System.currentTimeMillis() - time + "=====================================");
        System.out.println(list.size());

    }
}
