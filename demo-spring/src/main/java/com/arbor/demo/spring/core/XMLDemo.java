package com.arbor.demo.spring.core;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultBeanNameGenerator;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
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

        DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) context.getBeanFactory();
        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(String.class);
        beanFactory.registerBeanDefinition("testService", beanDefinition);

        simpleBean.send();
        context.close();
    }
}
