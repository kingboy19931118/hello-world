package com.arbor.note.juc;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author qiaomu.wang
 * @date 2018-06-25
 */
public class Demo {

    @Autowired
    private Car car;

    @Test
    public void test_() {
        BigDecimal bigDecimal = BigDecimal.valueOf(1.1);
        System.out.println(bigDecimal);
        System.out.println(JSON.toJSONString(bigDecimal));
    }

    @Test
    public void test_initializing() {
        System.out.println(car.hello());
    }

    @Test
    public void test_bigDecimal() {
        System.out.println(BigDecimal.valueOf(100000.123).setScale(2, RoundingMode.HALF_UP).stripTrailingZeros().toString());
        System.out.println(BigDecimal.valueOf(100000.123).setScale(1, RoundingMode.HALF_UP).stripTrailingZeros().toPlainString());
        System.out.println(BigDecimal.valueOf(100000.000).stripTrailingZeros().toPlainString());
        System.out.println(BigDecimal.valueOf(100000.000).toString());
    }

}

@Component
class Car implements InitializingBean {

    public String hello() {
        return "hello";
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(123123123);
    }
}
