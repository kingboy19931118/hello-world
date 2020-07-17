package com.arbor.note.basic;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;

/**
 * com.arbor.note.basic.LocalDateDemo
 *
 * @author Joem
 * @date 2020-07-16
 * @since v2.0.0
 */
public class LocalDateDemo {


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
