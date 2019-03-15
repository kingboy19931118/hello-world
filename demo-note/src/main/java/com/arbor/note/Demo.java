package com.arbor.note;

import java.math.BigDecimal;

/**
 * @author qiaomu.wang
 * @date 2018-09-30
 */
public class Demo {

    public static void main(String[] args) {
        double d = 1.0 - 0.9;
        System.out.println(d);

        BigDecimal d2 = BigDecimal.valueOf(1.0).subtract(BigDecimal.valueOf(0.9));
        System.out.println(d2);

        double i = 10 - 9;
        System.out.println(i);
    }
}
