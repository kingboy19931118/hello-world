package com.arbor.note.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class BIODemo {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true) {
            System.out.println("start accept");
            Socket socket = serverSocket.accept();
            System.out.println("new conn: " + socket.getRemoteSocketAddress());

            new Thread(()->{
                try {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    String msg;
                    // 读取消息
                    while ((msg = reader.readLine()) != null) {
                        if (msg.equalsIgnoreCase("quit")) {
                            reader.close();
                            socket.close();
                            break;
                        } else {
                            System.out.println("receive msg: " + msg);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}