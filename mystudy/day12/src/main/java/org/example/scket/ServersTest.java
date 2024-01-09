package org.example.scket;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServersTest {
    public static void main(String[] args) {
       ServerActive();
    }
        public static void ServerActive() {
        try {
            ServerSocket server = new ServerSocket(1234);
            Socket accept = server.accept();//  开始等待接受客户端请求
            InputStream in = accept.getInputStream();   //接收到客户端发送的信息
            OutputStream out = accept.getOutputStream();    //准备返回给客户端发送的信息
            while (true) {
                byte[] b = new byte[1024];
                int read = in.read(b);
                if (read > 0) {
                    System.out.println("服务端接收到的信息为：" + new String(b, 0, read));
                }
                System.out.println("服务端将要向客户端返回信息");
                Scanner sc = new Scanner(System.in);
                String msg = sc.nextLine();
                out.write(msg.getBytes());
                if (msg.equals("quit")) {
                    break;
                }
            }
            out.close();
            in.close();
            accept.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
