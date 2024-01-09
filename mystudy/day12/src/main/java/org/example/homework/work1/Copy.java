package org.example.homework.work1;

import java.io.*;
import java.net.Socket;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Copy implements Runnable {
    private Socket socket;

    public Copy() {
    }

    public Copy(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        while (true) {
            Scanner sc = new Scanner(System.in);
            BufferedInputStream bin = null;
            FileOutputStream out = null;
            try {
                bin = new BufferedInputStream(socket.getInputStream());
                System.out.println("请输入您要复制的目的地路径:");
                String line = sc.nextLine();    //  用户输入复制目的地路径
                File dest = new File(line);
                File parentFile = dest.getParentFile();
                if(!parentFile.exists()){
                    parentFile.mkdirs();
                }
                 out = new FileOutputStream(dest);
                byte[] b = new byte[1024];
                int len = 0;
                while((len = bin.read(b)) != -1) {
                    out.write(b,0,len);
                }
                out.flush();
                System.out.println("复制完成");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }finally {
                if (out != null) {
                    try {
                        out.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                if (bin != null) {
                    try {
                        bin.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

        }
    }
}
