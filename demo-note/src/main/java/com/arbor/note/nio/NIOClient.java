package com.arbor.note.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Selector;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * com.arbor.note.nio.NIOClient
 *
 * @author Joem
 * @date 2020-03-30
 * @since v2.0.0
 */
public class NIOClient {

    // 服务端地址
    private InetSocketAddress SERVER;

    // 读取缓冲区
    private ByteBuffer readBuffer = ByteBuffer.allocate(1024);

    // 写入缓冲区
    private ByteBuffer writeBuffer = ByteBuffer.allocate(1024);

    // 用户 监听 通道事件
    private static Selector selector;

    // 用户 编码/解码 buffer
    private Charset charset = StandardCharsets.UTF_8;

    public NIOClient(int port) {
        SERVER = new InetSocketAddress("localhost", port);
        try {
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void init() throws IOException {

    }

    public static void main(String[] args) {

    }
}
