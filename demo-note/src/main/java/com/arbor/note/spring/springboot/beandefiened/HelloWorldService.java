package com.arbor.note.spring.springboot.beandefiened;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * com.arbor.note.spring.springboot.beandefiened.HelloWorldService
 *
 * @author Joem
 * @date 2020-07-15
 * @since v2.0.0
 */
@Slf4j(topic = "mylogtopic")
@Scope(value = "singleton", scopeName = "singleton")
@DependsOn(value = {"a","b"})
@Data(staticConstructor = "")
@RestController
@Component("hello1")
@Service
public class HelloWorldService {

    @Autowired
    @Qualifier("a")
    private A a;

    private B b;

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

}
