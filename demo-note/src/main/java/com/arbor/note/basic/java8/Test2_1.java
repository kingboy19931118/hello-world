package com.arbor.note.basic.java8;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * com.arbor.note.basic.java8.Test2_1
 *
 * @author Joem
 * @date 2020-07-31
 * @since v2.0.0
 */
public class Test2_1 {

    public static void main(String[] args) {
        List<Apple> redApples = filter(Lists.newArrayList(), (Apple app) -> app.getColor().equals("red"));
        List<Integer> evenNumbers = filter(Lists.newArrayList(), (Integer num) -> num % 2 == 0);
    }

    public static List<Apple> filter(List<Apple> apples, ApplePredicate predicate) {
        List<Apple> result = Lists.newArrayList();
        for (Apple apple : apples) {
            if (predicate.test(apple)) {
                result.add(apple);
            }

        }

        return result;
    }

    public static void prettyPrintApple(List<Apple> apples, AppleFormatter formatter) {

        for (Apple apple : apples) {
            String out = formatter.apply(apple);
            System.out.println(out);
        }

    }

    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T e : list) {
            if (predicate.test(e)) {
                result.add(e);
            }
        }

        return result;
    }
}
