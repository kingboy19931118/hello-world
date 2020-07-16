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

    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
        DateTimeFormatter formatter1 =
                new DateTimeFormatterBuilder().appendPattern("yyyy-MM").parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
                .toFormatter();
        LocalDate date = LocalDate.parse("2018-07", formatter1);
        LocalDate begin = date.with(TemporalAdjusters.firstDayOfMonth());
        LocalDate end = date.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(begin.format(formatter));
        System.out.println(end.format(formatter));
    }
}
