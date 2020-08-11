package com.arbor.demo.spring.core;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * com.demo.spring.core.XMLDemo
 *
 * @author Joem
 * @date 2020-05-12
 * @since v2.0.0
 */
public class SingletonVsPrototypeDemo {

    public static void main(String[] args) {
        System.out.println(new Date().toString());
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/dev/sping-context.xml");

        List<MFile> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add((MFile) context.getBean("mFile"));
            System.out.println(list.size());
        }
//        SimpleBean simpleBean = (SimpleBean) context.getBean("simpleBean");
//        simpleBean.send();
        context.close();
    }
}
