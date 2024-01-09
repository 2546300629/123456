package cn.com.offcn.day10.runable;

import java.io.*;
import java.text.DecimalFormat;

public class RunableB implements Runnable {
    private static Object o = new Object();

    @Override
    public void run() {
        synchronized (o) {
            File source = new File("d:\\io\\考试系统.exe");
            File dest = new File("d:\\io\\com\\考试系统副本.exe");
            try {
                DecimalFormat df = new DecimalFormat("0.0000");   //  设置格式为小数格式
                FileInputStream in = new FileInputStream(source);
                FileOutputStream out = new FileOutputStream(dest);
                double autoresize = source.length();
                byte[] bytes = new byte[1024];
                int len = 0;
                int count = 0;  //  记录已经写出多少字节
                while ((len = in.read(bytes)) != -1) {
                    out.write(bytes, 0, len);
                    count += len;
                    System.out.println("线程B已经复制" + df.format((count / autoresize) * 100.00) + "%");
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
