package com.arbor.note.basic.memory;

import java.util.ArrayList;
import java.util.List;

/**
 * com.arbor.note.basic.memory.EscapeAnalyzeDemo
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
