package com.arbor.note.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qiaomu.wang
 * @date 2018-09-18
 */
public class InitialCapacityDemo {

    public static void main(String[] args) {
        HashMap<String, Object> map = new HashMap<>(8);
        System.out.println(map.size());
        map.put("1", "a");
        map.put("2", "a");
        map.put("3", "a");
        map.put("4", "a");
        map.put("5", "a");
        map.put("6", "a");
        map.put("7", "a");
        map.put("8", "a");
        System.out.println(map.size());

    }
}
