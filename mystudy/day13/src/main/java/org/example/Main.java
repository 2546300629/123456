package org.example;

import java.io.*;
import java.net.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(8089);   //  设置本地端口
        byte[] data2 = new byte[1024];
        while(true) {
            DatagramPacket packet2 = new DatagramPacket(data2,data2.length);
            socket.receive(packet2);    //  开启监听
            byte[] data = packet2.getData();
            System.out.println("接收数据" + packet2.getLength());
            File file = new File("D:\\io\\com\\test.doc");
            FileOutputStream out = new FileOutputStream(file,true);
            out.write(data,0,packet2.getLength());
            out.flush();
            if (packet2.getLength() != 1024){
                break;
            }
        }
    }
}