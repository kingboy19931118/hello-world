package com.arbor.note.basic.io;

import java.io.Serializable;

/**
 * com.arbor.note.basic.io.Color
 *
 * @author Joem
 * @date 2020-08-06
 * @since v2.0.0
 */
public class Color implements Serializable {
    private String color;

    private Integer deep;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getDeep() {
        return deep;
    }

    public void setDeep(Integer deep) {
        this.deep = deep;
    }

    @Override
    public String toString() {
        return "Color{" +
                "color='" + color + '\'' +
                ", deep=" + deep +
                '}';
    }
}
