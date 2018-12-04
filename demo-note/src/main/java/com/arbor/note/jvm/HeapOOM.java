package com.arbor.note.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 *  *VM Args：-Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 *
 * @author qiaomu.wang
 * @date 2018-12-04
 */
public class HeapOOM {
    static class OOMObject{

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}