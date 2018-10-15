package com.arbor.note.collection;

import com.google.common.collect.Lists;

import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author qiaomu.wang
 * @date 2018-10-08
 */
public class SortDemo {
    public static void main(String[] args) {
        stringListSort();
        intListSort();

    }

    private static void stringListSort() {
        List<String> sortList = Lists.newArrayList("张三", "李四", "王二狗", "整理下没电了卡猫阿拉开什么地方");
        List<String> sortedList = sortList.stream()
                .filter(s -> !"整理下没电了卡猫阿拉开什么地方".equals(s))
                .sorted(Comparator.comparing("李四"::equals).reversed()
                        .thenComparing(Comparator.comparing("王二狗"::equals).reversed()))
                .collect(toList());
        System.out.println(sortList);
        System.out.println(sortedList);
    }

    private static void intListSort() {
        List<Integer> sortList = Lists.newArrayList(666, 222, 123, 1, 2 ,3);
        List<Integer> sortedList = sortList.stream()
                .filter(s -> s != 666)
                .sorted(Comparator.comparing(o -> o != 123))
                .collect(toList());
        System.out.println(sortList);
        System.out.println(sortedList);
    }
}
