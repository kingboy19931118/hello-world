package com.arbor.note.basic.memory;

/**
 * com.arbor.note.basic.memory.EscapeAnalyzeDemo2
 * 公公表达式消除
 *
 * @author Joem
 * @date 2020-09-03
 * @since v2.0.0
 */
public class EscapeAnalyzeDemo2 {

    public static void main(String[] args) {
        int c = 1;
        int b = 2;
        int a = 3;
        int d = (c * b)  * 12 + a +  (a + b * c);
        System.out.println(d);
    }
}
