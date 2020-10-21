package com.arbor.note.basic.memory;

import java.util.ArrayList;
import java.util.List;

/**
 * com.arbor.note.basic.memory.JMMDemo
 *
 * @author Joem
 * @date 2020-08-18
 * @since v2.0.0
 */
public class JMMDemo {

    static class Data {
        Object[] arr = new Object[1024];
    }

    public static void main(String[] args) throws InterruptedException {
        List<Object[]> obj = new ArrayList<>();
        while (true) {
            obj.add(new Object[1024]);
            Thread.sleep(20L);
        }
    }
}
