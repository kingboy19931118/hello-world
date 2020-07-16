package com.arbor.demo.spring.core;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * com.demo.spring.core.XMLDemo
 *
 * @author Joem
 * @date 2020-05-12
 * @since v2.0.0
 */
public class XMLDemo {

    public static void main(String[] args) {
        System.out.println(new Date().toString());
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/dev/sping-context.xml");
        SimpleBean simpleBean = (SimpleBean) context.getBean("simpleBean");
        simpleBean.send();
        context.close();
    }
}
