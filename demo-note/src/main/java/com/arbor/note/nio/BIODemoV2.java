package com.arbor.note.nio;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * com.arbor.note.nio.BIODemoV2
 *
 * @author Joem
 * @date 2020-03-30
 * @since v2.0.0
 */
public class BIODemoV2 {
    public static final int portNumber = 8080;

    public static void main(String[] args) {


        try {
            ServerSocket serverSocket = new ServerSocket(portNumber);
            Socket clientSocket = serverSocket.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            String request = "";
            StringBuilder response = new StringBuilder();
            while ((request = in.readLine()) != null) {
                if ("Done".equalsIgnoreCase(request)) {
                    System.out.println(response);
                    break;
                }
                response.append(request);
                out.println(response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
