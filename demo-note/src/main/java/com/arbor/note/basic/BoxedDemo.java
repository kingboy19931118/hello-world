package com.arbor.note.basic;

/**
 * 自动拆装箱陷阱
 *
 * @author wangqiaomu
 * @date 2019-01-21 14:41
 **/
public class BoxedDemo {

    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f= 321;
        Long g = 3L;
        System.out.println(c == d);//true
        System.out.println(e == f);//false;
        System.out.println(c == (a + b));//false; --> true
        System.out.println(c.equals((a + b)));//true
        System.out.println(g == (a + b));//false --> true
        System.out.println(g.equals((a + b)));  //true    --》 false
    }
}
