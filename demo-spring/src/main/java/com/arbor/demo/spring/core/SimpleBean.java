package com.arbor.demo.spring.core;

import java.util.Date;

/**
 * com.arbor.demo.spring.core.SimpleBean
 *
 * @author Joem
 * @date 2020-05-12
 * @since v2.0.0
 */
public class SimpleBean {

    private String name;

    private Integer age;

    private Date date;


    public SimpleBean() {
    }

    public SimpleBean(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public SimpleBean(String name, Integer age, Date date) {
        this.name = name;
        this.age = age;
        this.date = date;
    }

    public void send() {
        System.out.println("Im simple demo bean; name=" + name + ",age=" + age + ",DATE=" + date + ".");
    }
}
