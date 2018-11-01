package com.arbor.note.datastructure;

import java.util.List;

/**
 * @author qiaomu.wang
 * @date 2018-10-24
 */
public class Stack<T> {
    private T[] data;

    private int maxSize;

    private int currentSign;

    public T pop() {
        if (currentSign >= 0) {
            T t = data[currentSign];
            currentSign--;
            return t;
        } else {
            return null;
        }
    }

    public void push(T t) {
        if (currentSign >= maxSize) {
            throw new ArrayIndexOutOfBoundsException();
        }
        currentSign++;
        data[currentSign] = t;
    }



}
