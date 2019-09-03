package com.arbor.note.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

public class NIOServer implements Runnable {

    private Selector selector;

    private ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

    }
}
