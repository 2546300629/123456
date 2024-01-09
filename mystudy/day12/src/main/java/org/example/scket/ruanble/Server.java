package org.example.scket.ruanble;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(1234);
        System.out.println("服务器等待连接中...");
        Socket accept = server.accept();
        System.out.println("连接成功");
        Thread write = new Thread(new WriteRunnable(accept));
        Thread read = new Thread(new ReadRunnable(accept));
        read.start();
        write.start();
    }
}
