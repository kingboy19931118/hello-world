package com.arbor.note.spring.springboot.feign;

import com.arbor.note.spring.springboot.beandefiened.B;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

/**
 * com.arbor.note.spring.springboot.beandefiened.A
 *
 * @author Joem
 * @date 2020-07-15
 * @since v2.0.0
 */
@Service(value = "atmp")
@Scope(value = "singleton", scopeName = "singleton", proxyMode = ScopedProxyMode.DEFAULT)
@Data
public class A {

    private Double aDouble;

    public A(Double aDouble) {
        this.aDouble = aDouble;
    }


    public String toString() {
        return aDouble.toString();
    }

}
