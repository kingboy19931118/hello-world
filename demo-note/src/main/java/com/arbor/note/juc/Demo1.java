package com.arbor.note.juc;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author qiaomu.wang
 * @date 2018-08-20
 */
public class Demo1 {

    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        System.out.println(date.format(DateTimeFormatter.ofPattern("yyyy/M/dd")));
        Date date1 = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/M/dd");
        System.out.println(sdf.format(date1));
        System.out.println(System.getenv());
    }
}
