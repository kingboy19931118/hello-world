package com.arbor.note.spring;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * com.arbor.note.spring.AopDemo
 *
 * @author Joem
 * @date 2020-07-15
 * @since v2.0.0
 */
@Component
@Aspect
public class AopDemo {


    @Before(value = "execution(String com.arbor.note.spring.springboot.beandefiened.*.index(..))")
    public void before(JoinPoint joinPoint) {
        System.out.println(joinPoint.getTarget().toString() + " _____------" + "before ...");
    }
}
