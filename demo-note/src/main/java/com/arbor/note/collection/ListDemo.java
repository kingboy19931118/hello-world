package com.arbor.note.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qiaomu.wang
 * @date 2018-12-20
 */
public class ListDemo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
//        for (int i = 0; i < list.size(); i++) {
//            if ("2".equals(list.get(i))) {
//                list.remove(list.get(i));
//            }
//        }
        for (String item : list) {
            if ("2".equals(item)) {
                list.remove(item);
            }
        }
    }

    public void demo1(Integer i) {

    }

    public String demo1() {
        return "";
    }
}
