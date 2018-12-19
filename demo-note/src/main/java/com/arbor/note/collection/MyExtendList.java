package com.arbor.note.collection;

/**
 * @author qiaomu.wang
 * @date 2018-12-19
 */
public class MyExtendList extends AbstractExtendList {

    public void del2(int i) {
//        super.d(i);
        super.list.remove(i);
    }

    public static void main(String[] args) {
        MyExtendList list = new MyExtendList();
        list.a("a");
        list.a("B");
        list.a("c");
        list.a("d");

        System.out.println(list.list);
        list.del2(3);
        System.out.println(list.list);
    }
}
