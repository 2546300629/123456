package org.example.homework.work1;

import java.io.IOException;
import java.net.Socket;

public class ClientDemo {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost",1234);
        SendSource sendSource = new SendSource(client); //  传输文件路径线程
        Thread send = new Thread(sendSource);
        send.start();
    }
}
