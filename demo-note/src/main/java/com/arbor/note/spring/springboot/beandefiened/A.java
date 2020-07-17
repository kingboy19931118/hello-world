package com.arbor.note.spring.springboot.beandefiened;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

/**
 * com.arbor.note.spring.springboot.beandefiened.A
 *
 * @author Joem
 * @date 2020-07-15
 * @since v2.0.0
 */
@Service(value = "a")
@Scope(value = "singleton", scopeName = "singleton", proxyMode = ScopedProxyMode.DEFAULT)
public class A {

    @Autowired
    @Qualifier(value = "b")
    private B b;
}
