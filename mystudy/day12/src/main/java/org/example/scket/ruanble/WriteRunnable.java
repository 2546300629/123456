package org.example.scket.ruanble;

import java.io.*;
import java.net.Socket;

public class WriteRunnable implements Runnable {
    private Socket s;

    public WriteRunnable() {
    }

    public WriteRunnable(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        synchronized ("0") {
            System.out.println(Thread.currentThread().getName() + "正在调用输入");
            PrintWriter pw = null;
            BufferedReader br = null;
            try {
                while (true) {
                    System.out.println("请输入信息:");
                    br = new BufferedReader(new InputStreamReader(System.in));
                    pw = new PrintWriter(s.getOutputStream());
                    String msg = br.readLine();
                    pw.println(msg);
                    pw.flush();
                    if (msg.equals("quit")) {
                        break;
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
