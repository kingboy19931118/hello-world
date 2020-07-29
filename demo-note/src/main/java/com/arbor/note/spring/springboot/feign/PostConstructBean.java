package com.arbor.note.spring.springboot.feign;

import com.arbor.note.collection.sort.Sort;
import com.google.common.collect.Lists;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * com.arbor.note.spring.springboot.feign.InitDestoryBean
 *
 * @author Joem
 * @date 2020-07-28
 * @since v2.0.0
 */

public class PostConstructBean {

    @PostConstruct
    public void init() {
        System.out.println(this.getClass().getSimpleName() + " init doing");
    }

    public PostConstructBean() {
        System.out.println(this.getClass().getSimpleName() + " 构造函数2 doing");
    }

    @PreDestroy
    public void destroy() {
        System.out.println(this.getClass().getSimpleName() + " destroy doing");
    }

    public static void main(String[] args) {
        A a1 = new A(1.2);
        A a2 = new A(2.4);
        A a3 = new A(1.1);
        A a4 = new A(5.6);
        A a5 = new A(1.1);

        List<A> doubles = Lists.newArrayList(a1,a2,a3,a4,a5);
//        doubles.sort((x, y) -> Double.compare(y, x));
//        System.out.println(doubles);


        List<A> collect =
                doubles.stream().sorted(Comparator.comparing(A::getADouble).reversed()).collect(Collectors.toList());
        System.out.println(collect);
//        List<Double> collect = doubles.stream().sorted(Comparator.comparing(A::getADouble).reversed()).collect(Collectors.toList());
//        System.out.println(collect);

//        List<Double> collect1 = doubles.stream().sorted(Comparator.comparing(Double::doubleValue).reversed()).collect(Collectors.toList());
//        System.out.println(collect1);
    }
}
