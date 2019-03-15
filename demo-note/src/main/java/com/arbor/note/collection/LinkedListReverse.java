package com.arbor.note.collection;

import java.util.LinkedList;

/**
 * @author wangqiaomu
 * @date 2019-01-23 15:17
 **/
public class LinkedListReverse {

    public static void main(String[] args) {

        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 10; ) {
            linkedList.add(++i);
        }

        System.out.println(linkedList);

        System.out.println(linkedList.poll());
        System.out.println(linkedList.poll());
        System.out.println(linkedList.poll());
        System.out.println(linkedList.pop());
        System.out.println(linkedList.pop());
        System.out.println(linkedList.pop());
        System.out.println(linkedList.pop());
        System.out.println(linkedList.peek());
        System.out.println(linkedList.peek());
        System.out.println(linkedList.peek());
        System.out.println(linkedList.peek());
        System.out.println(linkedList);
    }
}
