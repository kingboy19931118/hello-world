package com.arbor.note.juc.async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * com.arbor.note.juc.async.JavaPromise
 *
 * @author Joem
 * @date 2020-09-02
 * @since v2.0.0
 */
public class JavaPromise {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        CompletableFuture<String> future = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                Thread thread = Thread.currentThread();
                System.out.println("task begin" + thread.getId());
                JavaFuture.longTimeMethod();
                System.out.println("task finish" + thread.getId());
                return "task return!" + thread.getId();
            }
        });

        future.thenAccept(System.out::println).thenAccept(e -> System.out.println("then accept 2")).thenAccept(e -> System.out.println("then accept last"));
        CompletableFuture<String> future2 = new CompletableFuture<>();
        future2.thenAccept(e -> System.out.println(e + " future2 done"));

        System.out.println("main thread is running");

        Thread.sleep(5000L);

        System.out.println("main thread is finish");

        executor.shutdown();

    }
}
