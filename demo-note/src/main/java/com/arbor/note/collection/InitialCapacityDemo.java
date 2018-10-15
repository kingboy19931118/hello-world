package com.arbor.note.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 初始化List Map大小  初始化大小指定尽量为集合大小/负载因子 比如总共有6条数据 则最佳初始化大小为 6/0.75=8
 *
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

        ArrayList<Integer> arrayList = new ArrayList<>(16);
        System.out.println(arrayList.size());
    }
}
