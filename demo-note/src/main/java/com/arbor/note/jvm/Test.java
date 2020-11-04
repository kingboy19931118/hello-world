package com.arbor.note.jvm;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * com.arbor.note.jvm.Test
 *
 * @author Joem
 * @date 2020-11-02
 * @since v2.0.0
 */
public class Test {

    public static void main(String[] args) {
        Test test = new Test();
        List<String> strings = Arrays.asList("1", "2", "3", "1");
        System.out.println(test.filter(strings));
        System.out.println(test.filter2(strings));
    }

    /**
     * 过滤空数据及去重
     * @param data 入参数据
     * @return 返回值
     */
    public List<String> filter(List<String> data) {
        if (data == null) {
            return new ArrayList<>();
        }

        return data.stream()
                .filter(Objects::nonNull)
                .distinct()
                .collect(Collectors.toList());
    }

    /**
     * 过滤空 及 统计出现次数
     * @param data
     * @return
     */
    public Map<String, Long> filter2(List<String> data) {
        if (data == null) {
            return new HashMap<>();
        }
        return data.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    /**
     * 找到和 == sum 的人 时间复杂度O(logN)
     * @param totalPerson
     * @param sum
     * @return
     */
    public List<Person> findPerson(List<Person> totalPerson, int sum) {
        List<Person> collect =
                totalPerson.stream().filter(p -> p.getCode() < sum).sorted(Comparator.comparing(Person::getCode)).collect(Collectors.toList());

        int begin = 0;
        int end = collect.size() - 1;
        while (begin < end) {
            Person beginPerson = collect.get(begin);
            Person endPerson = collect.get(end);


            int currentSum = beginPerson.getCode() + endPerson.getCode();

            // code > sum
            if (currentSum > sum) {
                end--;
                continue;
            }

            // code < sum
            if (currentSum < sum) {
                begin++;
                continue;
            }

            // code 和 等于 sum
            return Arrays.asList(beginPerson, endPerson);
        }


        return Collections.emptyList();
    }

    /**
     * 找到和 == sum 的人 复杂度O(N)
     * @param totalPerson
     * @param sum
     * @return
     */
    public List<Person> findPerson2(List<Person> totalPerson, int sum) {
        if (totalPerson == null || totalPerson.isEmpty()) {
            return Collections.emptyList();
        }
        Map<Integer, Person> maps = new HashMap<>(totalPerson.size());

        for (Person person : totalPerson) {
            Person value = maps.get(person.getCode());
            if (value != null) {
                return Arrays.asList(person, value);
            } else {
                maps.put(sum - person.getCode(), person);
            }
        }

        return Collections.emptyList();
    }


    static class Person {
        private String name;
        private int code;

        public Person() {
        }

        public Person(String name, int code) {
            this.name = name;
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }
    }

}
