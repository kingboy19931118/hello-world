package com.arbor.note.juc;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author wangqiaomu
 * @date 2019-06-18 13:58
 **/
public class SimpleDateFormatDemo {

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Executor executor = new ThreadPoolExecutor(10, 15, 300, TimeUnit.SECONDS, new LinkedBlockingDeque<>(20), new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            executor.execute(() -> {
                while (true) {
                    System.out.println(sdf.format(new Date(10000000000L * finalI)));
                    try {
                        Thread.sleep(500L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
