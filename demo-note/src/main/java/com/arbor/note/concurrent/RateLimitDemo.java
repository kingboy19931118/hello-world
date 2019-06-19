package com.arbor.note.concurrent;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.TimeUnit;

/**
 * @author wangqiaomu
 * @date 2019-06-12 19:24
 **/
public class RateLimitDemo {

    public static void main(String[] args) throws InterruptedException {
        RateLimiter rateLimiter = RateLimiter.create(1);
        for (int i = 1; i < 20; i++) {
            if (rateLimiter.tryAcquire(0, TimeUnit.SECONDS)) {
//            double time = rateLimiter.acquire(i);
                System.out.println("doing" + i + " 耗时：" + "time");
            }

            Thread.sleep(500);
        }
    }
}
