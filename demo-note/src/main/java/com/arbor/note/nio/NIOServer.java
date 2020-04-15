package com.arbor.note.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class NIOServer implements Runnable {

    private Selector selector;

    private ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

    private ByteBuffer serverByteBuffer = ByteBuffer.allocate(1024);

    private Map<String, SocketChannel> clientMap = new HashMap<>();

    public NIOServer(int port) {
        try {
            // 创建一个selector轮询器
            selector = Selector.open();

            // 创建一个serverSocketChannel
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

            // 绑定端口
            serverSocketChannel.bind(new InetSocketAddress(port), 1024);

            // 配置是否阻塞
            serverSocketChannel.configureBlocking(false);

            // 注册到 selector 监听
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("服务端启动成功，端口为：" + port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                selector.select();
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                selectionKeys.forEach(key -> {
                    if (key.isAcceptable()) {
                        ServerSocketChannel server = (ServerSocketChannel) key.channel();
                        System.out.println("客户端接入:" + server.toString());
                        try {
                            SocketChannel client = server.accept();
                            client.configureBlocking(false);
                            client.register(selector, SelectionKey.OP_READ);
                            clientMap.put(getClientName(client), client);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (key.isReadable()) {
                        SocketChannel channel = (SocketChannel) key.channel();
                        byteBuffer.clear();
                        try {
                            int bytes = channel.read(byteBuffer);
                            if (bytes > 0) {
                                byteBuffer.flip();
                                String receiveText = String.valueOf(StandardCharsets.UTF_8.decode(byteBuffer));
                                System.out.println(channel.toString() + ":" + receiveText);
                                dispatch(channel, receiveText);
                            }

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
                selectionKeys.clear();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String getClientName(SocketChannel client) {
        return client.socket().getInetAddress().toString() + ":" + Integer.toHexString(client.hashCode());
    }

    private void dispatch(SocketChannel channel, String receiveText) throws IOException {
        if (clientMap.isEmpty()) {
            return;
        }

        clientMap.entrySet().forEach(entry -> {
            SocketChannel temp = entry.getValue();
            if (channel.equals(temp)) {
                return;
            }
            serverByteBuffer.clear();
            serverByteBuffer.put(StandardCharsets.UTF_8.encode(getClientName(channel) + ":" + receiveText));
            serverByteBuffer.flip();
            try {
                temp.write(serverByteBuffer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public static void main(String[] args) throws InterruptedException {
        new NIOServer(8080).run();
    }
}
