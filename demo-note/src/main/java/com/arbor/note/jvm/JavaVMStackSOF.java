package com.arbor.note.jvm;

/**
 * VM Args：-Xss128k
 *
 * @author qiaomu.wang
 * @date 2018-12-04
 */
public class JavaVMStackSOF {

    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }


//    public static void main(String[] args) {
//        JavaVMStackSOF javaVMStackSOF = new JavaVMStackSOF();
//        try {
//            javaVMStackSOF.stackLeak();
//        } catch (Throwable e) {
//            System.out.println("stack length：" + javaVMStackSOF.stackLength);
//            throw e;
//        }
//
//    }


    private void dontStop() {

        while (true) {

        }

    }

    public void stackLeakByThread() {

        while (true) {

            Thread thread = new Thread(new Runnable() {

                @Override

                public void run() {

                    dontStop();

                }

            });

            thread.start();

        }

    }

    /**
     * VM Args：-Xss2M(这时候不妨设置大些)
     *
     * @param args
     * @throws Throwable
     */
    public static void main(String[] args) throws Throwable {

        JavaVMStackSOF oom = new JavaVMStackSOF();

        oom.stackLeakByThread();

    }

}