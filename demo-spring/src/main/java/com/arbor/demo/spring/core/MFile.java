package com.arbor.demo.spring.core;

/**
 * com.arbor.demo.spring.core.MFile
 *
 * @author Joem
 * @date 2020-08-11
 * @since v2.0.0
 */
public class MFile {
    private byte[] arr = new byte[1024 * 1024];

    public byte[] getArr() {
        return arr;
    }

    public void setArr(byte[] arr) {
        this.arr = arr;
    }
}
