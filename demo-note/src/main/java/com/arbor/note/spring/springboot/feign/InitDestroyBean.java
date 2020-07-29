package com.arbor.note.spring.springboot.feign;

import org.springframework.context.annotation.Bean;

/**
 * com.arbor.note.spring.springboot.feign.InitDestoryBean
 *
 * @author Joem
 * @date 2020-07-28
 * @since v2.0.0
 */

public class InitDestroyBean {

    public void init() {
        System.out.println(this.getClass().getSimpleName() + " init doing");
    }

    public InitDestroyBean() {
        System.out.println(this.getClass().getSimpleName() + " 构造函数 doing");
    }

    public void destroy() {
        System.out.println(this.getClass().getSimpleName() + " destroy doing");
    }
}
