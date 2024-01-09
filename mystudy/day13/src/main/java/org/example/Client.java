package org.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(8088);
        File file = new File("D:\\io\\b.doc");
        FileInputStream in = new FileInputStream(file);
        byte[] b = new byte[1024];
        int len = 0;
        while ((len = in.read(b)) != -1) {
            DatagramPacket packet = new DatagramPacket(b, len, InetAddress.getByName("localhost"),8089);
            System.out.println(packet.getLength());

            socket.send(packet);
        }


//        设置发送地址并将发送的信息打包进去
//        DatagramPacket packet = new DatagramPacket(data, data.length, InetAddress.getByName("localhost"),8089);
//        socket.send(packet);
//        byte[] data = packet.getData();
//        System.out.println(Arrays.toString(data));
    }
}
