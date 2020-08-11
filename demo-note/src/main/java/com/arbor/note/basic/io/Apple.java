package com.arbor.note.basic.io;

import java.io.Serializable;

/**
 * com.arbor.note.basic.io.Apple
 *
 * @author Joem
 * @date 2020-08-06
 * @since v2.0.0
 */
public class Apple implements Serializable{
    private static final Long serialVersionUID = 1L;

//    private Color color;

    private Integer weight;

    private String name;

//    public Color getColor() {
//        return color;
//    }
//
//    public void setColor(Color color) {
//        this.color = color;
//    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Apple{" +
//                "color=" + color +
                ", weight=" + weight +
                ", name='" + name + '\'' +
                '}';
    }
}
