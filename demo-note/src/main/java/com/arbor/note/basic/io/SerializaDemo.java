package com.arbor.note.basic.io;

import com.alibaba.fastjson.JSON;

import java.io.*;

/**
 * com.arbor.note.basic.io.SerializaDemo
 *
 * @author Joem
 * @date 2020-08-06
 * @since v2.0.0
 */
public class SerializaDemo {

    public static void main(String[] args) {
        Color color = new Color();
        color.setDeep(50);
        color.setColor("red");
        Apple apple = new Apple();
//        apple.setColor(color);
        apple.setName("红富士");
        apple.setWeight(150);

        System.out.println(apple);

        byte[] bytes = JSON.toJSONString(apple).getBytes();
        Object apple2 = JSON.parseObject(bytes, Apple.class);
        System.out.println(apple2);

        byte[] bytes1 = toByteArray(apple);
        Object o = toObject(bytes1);
        System.out.println(o);

    }

    /**
     * 对象转数组
     * @param obj
     * @return
     */
    public static byte[] toByteArray (Object obj) {
        byte[] bytes = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(obj);
            oos.flush();
            bytes = bos.toByteArray ();
            oos.close();
            bos.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return bytes;
    }

    /**
     * 数组转对象
     * @param bytes
     * @return
     */
    public static Object toObject (byte[] bytes) {
        Object obj = null;
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream (bytes);
            ObjectInputStream ois = new ObjectInputStream (bis);
            obj = ois.readObject();
            ois.close();
            bis.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return obj;
    }

}
