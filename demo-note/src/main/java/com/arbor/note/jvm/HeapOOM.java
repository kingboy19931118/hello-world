package com.arbor.note.jvm;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 *  *VM Args：-Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 *
 * @author qiaomu.wang
 * @date 2018-12-04
 */
public class HeapOOM {
    static class OOMObject{
        byte[] m20 = new byte[1024 * 20];
        byte[] m21 = new byte[1024 * 20];
        byte[] m22 = new byte[1024 * 20];
        byte[] m23 = new byte[1024 * 20];
        byte[] m24 = new byte[1024 * 20];
    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }


    }

    /**
     * 过滤空数据及去重
     * @param data 入参数据
     * @return 返回值
     */
    public List<String> filter(List<String> data) {
        return data.stream().filter(Objects::nonNull).distinct().collect(Collectors.toList());
    }
}