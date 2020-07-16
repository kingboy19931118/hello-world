package com.arbor.note.basic;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * com.arbor.note.basic.InnerClazzDemo
 * 内部类
 *
 * @author Joem
 * @date 2020-06-12
 * @since v2.0.0
 */
public class InnerClazzDemo {

    public static void main(String[] args) {
        String name = getUserName();
//        name = "abc";
        Button button = new Button();
        button.addActionListener(event -> System.out.println("hi " + name));
    }

    private static String getUserName() {
        return "zhangsan";
    }
}
