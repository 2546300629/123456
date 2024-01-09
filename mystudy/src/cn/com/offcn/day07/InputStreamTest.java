package cn.com.offcn.day07;

import java.io.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

public class InputStreamTest {
    public static void main(String[] args) throws Exception {
        File file = new File("D:\\io\\a.txt");
//        inputStream(file);
        outStream(file);
    }

    public static void inputStream(File file) {
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
            byte[] b = new byte[1024];
            int read = 0;
            while (read != -1) {
                read = inputStream.read(b);
                if (read != -1) {
                    System.out.println(new String(b, 0, read));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static void outStream(File file) throws Exception {
        FileOutputStream outputStream = new FileOutputStream(file);
        String str = "你好你好";
        outputStream.write(str.getBytes());
    }

    public static void createFile() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入如您的文件路径");
        String path = sc.nextLine();
        System.out.println("请输入您的文件名称");
        String name = sc.nextLine();
        new File(path);
    }

    public boolean copy(File source,File dest,boolean append) {
        DecimalFormat nf = (DecimalFormat) NumberFormat.getPercentInstance();
        nf.applyPattern("00%"); //00表示小数点2位
        nf.setMaximumFractionDigits(2); //2表示精确到小数点后2位

        long totalSize = source.length();
        FileInputStream  in=null;
        FileOutputStream out=null;
        try {
            //判断目标文件得父目录是否存在
            File parentFile = dest.getParentFile();
            if(!parentFile.exists()){
                parentFile.mkdirs();
            }

            in=new FileInputStream(source);
            out=new FileOutputStream(dest,append);
            //读取文件
            byte  [] b=new  byte[1024];
            int len=0;
            double count = 0;
            while ((len=in.read(b))!=-1){
                //内容  要写出去
                out.write(b,0,len);
                count += len;
                System.out.println("已经复制" + nf.format(count/totalSize));
            }
            //擦写
            out.flush();;//强制把缓冲区得数据写入到目的地
            return  true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (out!=null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(in!=null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

        return false;
    }

    public boolean mycopy(File source,File dest,boolean append) throws Exception{
        if (!dest.getParentFile().exists()) {
            dest.mkdirs();
        }

        DecimalFormat df = new DecimalFormat("0.00");
        FileInputStream fileInputStream = new FileInputStream(source);
        FileOutputStream fileOutputStream = new FileOutputStream(dest);
        byte[] b = new  byte[1024];
        int len = fileInputStream.read(b);
        long totlesize = source.length();
        double count = 0;
        while(len != -1){
            fileOutputStream.write(b,0,len);
            count+=len;
            System.out.println("已经复制" + df.format((count/totlesize)*100.00) + "%");
            len = fileInputStream.read(b);
        }
        fileOutputStream.flush();
        fileOutputStream.close();
        fileInputStream.close();
        if (len == -1) {
            System.out.println("复制结束");
            return true;
        }
        return false;
    }
}
