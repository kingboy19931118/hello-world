package com.arbor.note.basic.java8;

import java.io.Serializable;

/**
 * com.arbor.note.basic.java8.Apple
 *
 * @author Joem
 * @date 2020-07-31
 * @since v2.0.0
 */
public class Apple implements Serializable {

    private Integer weight;

    private String color;

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }
}
