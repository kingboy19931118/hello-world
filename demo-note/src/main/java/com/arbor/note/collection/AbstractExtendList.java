package com.arbor.note.collection;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author qiaomu.wang
 * @date 2018-12-19
 */
public class AbstractExtendList implements ListInterface {
    List<Object> list = Lists.newLinkedList();

    @Override
    public void d(int i) {
        System.out.println("父类 delete");
        list.remove(i);
    }

    @Override
    public void a(Object o) {
        System.out.println("父类 add");
        list.add(o);
    }
}
