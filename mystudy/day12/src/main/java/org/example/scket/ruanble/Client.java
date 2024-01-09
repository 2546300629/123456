package org.example.scket.ruanble;

import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost",1234);
        Thread write = new Thread(new WriteRunnable(socket));
        Thread read = new Thread(new ReadRunnable(socket));
        read.start();
        write.start();
    }
}
