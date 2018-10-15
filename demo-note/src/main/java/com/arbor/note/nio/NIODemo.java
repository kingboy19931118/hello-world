package com.arbor.note.nio;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author qiaomu.wang
 * @date 2018-09-28
 */
public class NIODemo {

    public static void main(String[] args) {
        methodReadAbsolutePath();
        methodReadRelativePath();

    }

    private static void methodReadRelativePath() {
        InputStream in = null;
        try {
            in = new BufferedInputStream(new FileInputStream("abc.txt"));

            byte[] buf = new byte[1024];
            int bytesRead = in.read(buf);
            while (bytesRead != -1) {
                for (int i = 0; i < bytesRead; i++) {
                    System.out.println((char) buf[i]);
                }
                bytesRead = in.read(buf);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 绝对路径查找文件.  系统文件夹 c:/abc.txt
     */
    private static void methodReadAbsolutePath() {
        InputStream in = null;
        try {
//            in = new BufferedInputStream(new FileInputStream("/abc.txt"));
            in = new BufferedInputStream(new FileInputStream("c:/abc.txt"));

            byte[] buf = new byte[1024];
            int bytesRead = in.read(buf);
            while (bytesRead != -1) {
                for (int i = 0; i < bytesRead; i++) {
                    System.out.println((char) buf[i]);
                }
                bytesRead = in.read(buf);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
