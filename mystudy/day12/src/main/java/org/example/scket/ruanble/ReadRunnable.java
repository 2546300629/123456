package org.example.scket.ruanble;

import org.example.scket.SocketTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReadRunnable implements Runnable {
    private Socket socket;

    public ReadRunnable() {
    }

    public ReadRunnable(Socket s) {
        this.socket = s;
    }

    @Override
    public void run() {
        System.out.println("接受信息");
        synchronized ("0") {
            BufferedReader br = null;
            try {
                while (true) {
                    br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    String msg = br.readLine();
                    System.out.println("接收到消息：" + msg);
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
