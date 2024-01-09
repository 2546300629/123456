package org.example.homework.work1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(1234);
        System.out.println("正在等待连接");
        Socket accept = server.accept();    //  服务器开始等待客户端连接访问
        System.out.println("连接成功");
        Copy runnable = new Copy(accept);
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
