package com.arbor.note.spring.springboot.feign;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * com.arbor.note.spring.springboot.feign.ConfigurationTest
 *
 * @author Joem
 * @date 2020-07-28
 * @since v2.0.0
 */
@Configuration
public class ConfigurationTest {

    @Bean(initMethod = "init",
            destroyMethod = "destroy")
    public InitDestroyBean getInitDestroyBean() {
        return new InitDestroyBean();
    }

    @Bean
    public PostConstructBean getPostConstructBean() {
        return new PostConstructBean();
    }
}
