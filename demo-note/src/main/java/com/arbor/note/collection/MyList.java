package com.arbor.note.collection;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author qiaomu.wang
 * @date 2018-12-19
 */
public class MyList {
    List<String> list;

    public MyList() {
        this.list = Lists.newLinkedList();
        list.add("a");
        list.add("B");
        list.add("c");
        list.add("D");
    }

    public boolean removeElement(int index) {
        list.remove(index);
        return true;
    }


    public static void main(String[] args) {
        MyList myList = new MyList();
        myList.removeElement(3);
        myList.removeElement(2);
        myList.removeElement(1);
        System.out.println(myList.list);
    }
}
