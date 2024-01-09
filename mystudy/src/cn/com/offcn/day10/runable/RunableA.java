package cn.com.offcn.day10.runable;

import cn.com.offcn.day07.FileTest;

import java.io.*;
import java.text.DecimalFormat;

public class RunableA implements Runnable {
    private static Object o = new Object();

    @Override
    public void run() {
        synchronized (o) {
            try {
                DecimalFormat df = new DecimalFormat("0.0000");   //  设置格式为小数格式
                File source = new File("d:\\io\\cts.exe");
                File dest = new File("d:\\io\\com\\ctscopy.exe");
                FileInputStream in = new FileInputStream(source);
                FileOutputStream out = new FileOutputStream(dest);
                double autoresize = source.length();
                byte[] bytes = new byte[1024];
                int len = 0;
                while ((len = in.read(bytes)) != -1) {
                    out.write(bytes, 0, len);
                    double length = dest.length();
                    double load = Double.parseDouble(df.format((length / autoresize) * 100.00));
                    System.out.println("线程A已经复制" + load + "%");
                }
                out.close();
                in.close();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
