package org.example.scket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class SocketTest {
    public static void main(String[] args) {
       ClientActive();
    }
    public static void ClientActive() {
        try {
            Socket socket = new Socket("localhost",1234);   //  连接服务端
            OutputStream out = socket.getOutputStream();    //  创建流准备进行传输
            InputStream in = socket.getInputStream();
            Scanner sc = new Scanner(System.in);
            while(true) {
                System.out.println("客户端准备向服务端发送数据");
                String msg = sc.nextLine();
                out.write(msg.getBytes());
                if (msg.equals("quit")){
                    break;
                }
                System.out.println("客户端等待服务端发送数据");
                byte[] b = new byte[1024];
                int read = in.read(b);
                System.out.println("客户端接收到服务端的信息:" + new String(b, 0, read));
            }
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
