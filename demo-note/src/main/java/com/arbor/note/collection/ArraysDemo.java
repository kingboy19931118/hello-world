package com.arbor.note.collection;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * @author wangqiaomu
 * @date 2019-06-10 16:50
 **/
public class ArraysDemo {

    public static void main(String[] args) {

        DemoFunction f = new DemoFunction();
        f.functionA();
        System.out.println("==================================");
        f.functionB();
        System.out.println("==================================");
        f.functionD();
    }



}

class DemoFunction {

    public void functionA() {
        int[] arr = {1, 2, 3};
        List<int[]> ints = Arrays.asList(arr);
        System.out.println(ints.size());
        System.out.println(JSON.toJSONString(ints));

        Integer[] arr2 = {1, 2, 3};
        List<Integer> int2s = Arrays.asList(arr2);
        System.out.println(int2s.size());
        System.out.println(JSON.toJSONString(int2s));
    }

    public void functionB() {
        String[] arr = {"欢迎", "关注", "Java"};
        List list = Arrays.asList(arr);
        arr[1] = "love";
        list.set(2, "golang");
        System.out.println(Arrays.toString(arr));
        System.out.println(list.toString());
        System.out.println(JSON.toJSONString(list));
    }

    public void functionD() {
        Hashtable hashtable = new Hashtable();
        hashtable.put(new Object(), new Object());

        HashMap hashMap = new HashMap();
        hashMap.put(null, null);

        TreeMap<Object, Object> treeMap = new TreeMap();
        treeMap.put(3, "c");
        treeMap.put(30, "c30");
        treeMap.put(2, "b");
        treeMap.put(1, "abcaaa");
        System.out.println(treeMap);
    }
}
