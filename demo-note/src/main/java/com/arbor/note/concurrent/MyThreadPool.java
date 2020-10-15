package com.arbor.note.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * com.arbor.note.concurrent.MyThreadPool
 *
 * @author Joem
 * @date 2020-10-14
 * @since v2.0.0
 */
public class MyThreadPool implements IThreadPool {


    private int coreSize;
    private int maxSize;

    private AtomicInteger currentCount = new AtomicInteger(0);

    private BlockingQueue<Runnable> queue;

    public MyThreadPool(int coreSize, int maxSize, AtomicInteger currentCount, BlockingQueue<Runnable> queue) {
        this.coreSize = coreSize;
        this.maxSize = maxSize;
        this.currentCount = currentCount;
        this.queue = queue;
    }

    public MyThreadPool(int coreSize, int maxSize, BlockingQueue<Runnable> queue) {
        this.coreSize = coreSize;
        this.maxSize = maxSize;
        this.queue = queue;
    }

    @Override
    public void execute(Runnable runnable) {
        int currentThread = currentCount.get();
        if (currentThread < coreSize) {
            if (!addWorker(runnable, true)) {
                reject();
            }
        } else {
            System.out.println("队列大小!" + queue.size());
            if (!queue.offer(runnable)) {
                System.out.println("offer 失败！ 队列已满 + " + queue.size());
                if (!addWorker(runnable, false)) {
                    reject();
                }
            }
        }
    }

    public boolean addWorker(Runnable runnable, boolean core) {
        if (currentCount.get() > maxSize) {
            return false;
        }

        Worker worker = new Worker(runnable);
        worker.start();
        return true;
    }
    public void reject () {
        throw new RuntimeException("超过线程数量！ 线程数=" + currentCount.get() + "| 队列大小=" + queue.size());
    }

    public class Worker extends Thread {
        private Runnable runnable;

        public Worker(Runnable runnable) {
            this.runnable = runnable;
            System.out.println("创建线程:当前线程数=" + currentCount.incrementAndGet());
        }

        @Override
        public void run() {
            try {
                while (true) {
                    runnable.run();
                    System.out.println("线程运行结束!当前线程数:" + currentCount.get());
                    if (currentCount.get() > coreSize) {
                        break;
                    } else {
                        try {
                            System.out.println("队列大小：" + queue.size());
                            runnable = queue.take();
                            System.out.println("队列大小：" + queue.size());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } finally {
                System.out.println("结束线程！当先线程数=" + currentCount.decrementAndGet());
            }
        }
    }

    public static void main(String[] args) {
        Thread.currentThread().setName("main");
        MyThreadPool pool = new MyThreadPool(2, 2, new ArrayBlockingQueue<>(3));
        for(int i=0;i<100;i++){
            final  int j = i;
            System.out.println("i="+i+" "+Thread.currentThread().getName());
            pool.execute(()->{
                try {
                    Thread.sleep(100);
                    System.out.println("睡0.1秒 完成:"+j);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
