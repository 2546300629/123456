package org.example.url;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.DatagramPacket;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class UrlSend {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://t7.baidu.com/it/u=289562621,657690689&fm=193&f=GIF");
        URLConnection urlConnection = url.openConnection();
        urlConnection.connect();
        InputStream in = urlConnection.getInputStream();
        FileOutputStream out = new FileOutputStream(new File("d:\\io\\a.jpg"));
        byte[] b = new byte[1024];
        int len = 0;
        while((len = in.read(b))!= -1){
            out.write(b,0,len);
        }
        out.close();
        in.close();
    }
}
