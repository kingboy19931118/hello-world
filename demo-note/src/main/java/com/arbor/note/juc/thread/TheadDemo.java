package com.arbor.note.juc.thread;

/**
 * @author qiaomu.wang
 * @date 2018-12-21
 */
public class TheadDemo {

    public static class Thread3 extends Thread{
        @Override
        public void run(){
            try{
                    // do more work;
                    Thread.sleep(300);
                    System.out.println("doing");
            }catch(InterruptedException e){
                // thread was interrupted during sleep or wait
                e.printStackTrace();
                System.out.println("error");
            }
            finally{
                // cleanup, if required
                System.out.println("finally");
            }
        }


    }
    public static void main(String[] args){
        Thread3 t = new Thread3();
        t.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(t.isInterrupted());
        System.out.println(t.getState());
        t.interrupt();
    }
}
