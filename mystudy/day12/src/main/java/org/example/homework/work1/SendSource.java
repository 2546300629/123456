package org.example.homework.work1;

import java.io.*;
import java.net.Socket;
import java.text.DecimalFormat;
import java.util.Scanner;

public class SendSource implements Runnable {
    private Socket socket;

    public SendSource() {
    }

    public SendSource(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        DecimalFormat df = new DecimalFormat("00.000%");
        Scanner sc = new Scanner(System.in);
        FileInputStream in = null;
        OutputStream out = null;
        while (true) {
            synchronized ("0") {
                System.out.println("请输入您要读取的文件路径");
                try {
                    String msg = sc.nextLine();
                    File source = new File(msg);
                    while (!source.exists()){
                        System.out.println("您输入的文件不存在，请重新输入");
                        source = new File(sc.nextLine());
                    }
                    long length = source.length();
                   in = new FileInputStream(source);
                    out = socket.getOutputStream();
                    byte[] b = new byte[1024];
                    int len = 0;
                    double sum = 0;
                    while((len = in.read(b)) != -1) {
                        out.write(b,0,len);
                        sum+=len;
                        System.out.println("正在发送..." + df.format(sum / length));
                    }
                    out.flush();
                    System.out.println("发送完成");
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }finally {
//                    if (out != null) {
//                        try {
//                            out.close();
//                        } catch (IOException e) {
//                            throw new RuntimeException(e);
//                        }
//                    }
//                    if (in != null) {
//                        try {
//                            in.close();
//                        } catch (IOException e) {
//                            throw new RuntimeException(e);
//                        }
//                    }
                }
            }
        }
    }
}
