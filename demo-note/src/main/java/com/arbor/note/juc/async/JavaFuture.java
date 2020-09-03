package com.arbor.note.juc.async;

import java.util.List;
import java.util.concurrent.*;

/**
 * com.arbor.note.juc.async.JavaFuture
 *
 * @author Joem
 * @date 2020-09-02
 * @since v2.0.0
 */
public class JavaFuture {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<String> f = executor.submit(new Callable<String>() {

            @Override
            public String call() throws Exception {
                System.out.println("task started!");
                longTimeMethod();
                System.out.println("task finished!");
                return "hello" +Thread.currentThread().getName();
            }
        });


        Callable<String> callable = new Callable<String>() {

            @Override
            public String call() throws Exception {
                System.out.println("task started!");
                longTimeMethod();
                System.out.println("task finished!");
                return "hello" + Thread.currentThread().getName();
            }
        };
        executor.submit(callable);
        executor.submit(callable);
        executor.submit(callable);
        executor.submit(callable);
        executor.submit(callable);
        executor.submit(callable);

//        System.out.println("=================" + call);

        //此处get()方法阻塞main线程
        System.out.println("main thread is already");
//        f.isDone()
        System.out.println(f.get());
        System.out.println("main thread is blocked");
        List<Runnable> runnables = executor.shutdownNow();
        System.out.println(runnables);
    }

    public static void longTimeMethod() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
