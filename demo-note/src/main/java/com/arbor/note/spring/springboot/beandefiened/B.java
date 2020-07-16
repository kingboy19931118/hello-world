package com.arbor.note.spring.springboot.beandefiened;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 * com.arbor.note.spring.springboot.beandefiened.B
 *
 * @author Joem
 * @date 2020-07-15
 * @since v2.0.0
 */
@Component(value = "b")
@Scope(value = "singleton", scopeName = "singleton", proxyMode = ScopedProxyMode.DEFAULT)
public class B {

    @Autowired
    @Qualifier(value = "a")
    private A a;
}
