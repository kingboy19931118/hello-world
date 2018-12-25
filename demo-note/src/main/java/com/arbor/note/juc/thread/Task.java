package com.arbor.note.juc.thread;

/**
 * @author qiaomu.wang
 * @date 2018-12-25
 */
public class Task {

    private String getData1;
    private String getData2;

//    public synchronized void doLongTimeTask() {
    public void doLongTimeTask() {
        try {
            System.out.println("begin task");
            Thread.sleep(3000);
            String getData1 = "长时间处理任务后从远程返回的值 1 threadName="
                    + Thread.currentThread().getName();
            String getData2 = "长时间处理任务后从远程返回的值 2 threadName="
                    + Thread.currentThread().getName();
            // 核心的不同的地方
            synchronized (this) {
                this.getData1 = getData1;
                this.getData2 = getData2;
            }
            System.out.println(this.getData1);
            System.out.println(this.getData2);
            System.out.println("end task");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

class CommonUtils {

    public static long beginTime1;
    public static long endTime1;

    public static long beginTime2;
    public static long endTime2;
}


class Aokay1Thread extends Thread {
    private Task task;
    public Aokay1Thread(Task task) {
        super();
        this.task = task;
    }
    @Override
    public void run() {
        super.run();
        CommonUtils.beginTime1 = System.currentTimeMillis();
        task.doLongTimeTask();
        CommonUtils.endTime1 = System.currentTimeMillis();
    }
}


class Aokay2Thread extends Thread {
    private Task task;
    public Aokay2Thread(Task task) {
        super();
        this.task = task;
    }
    @Override
    public void run() {
        super.run();
        CommonUtils.beginTime2 = System.currentTimeMillis();
        task.doLongTimeTask();
        CommonUtils.endTime2 = System.currentTimeMillis();
    }
}


class Run {

    public static void main(String[] args) {
        Task task = new Task();

        Aokay1Thread at1 = new Aokay1Thread(task);
        at1.start();

        Aokay2Thread at2 = new Aokay2Thread(task);
        at2.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long beginTime = CommonUtils.beginTime1;
        if (CommonUtils.beginTime2 < CommonUtils.beginTime1) {
            beginTime = CommonUtils.beginTime2;
        }

        long endTime = CommonUtils.endTime1;
        if (CommonUtils.endTime2 > CommonUtils.endTime1) {
            endTime = CommonUtils.endTime2;
        }

        System.out.println("耗时：" + ((endTime - beginTime) / 1000));
    }
}