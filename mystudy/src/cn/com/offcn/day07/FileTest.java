package cn.com.offcn.day07;

import java.io.*;

public class FileTest {
    public static void main(String[] args) throws Exception {
//        InputStreamTest inputStreamTest = new InputStreamTest();
//        inputStreamTest.mycopy(new File("D:\\io\\Atm.java"),new File("D:\\io\\io.java"),false);
        test();
    }

    public static void findAllTxt(File file) {
        for (File f : file.listFiles()) {
            if (f.getName().endsWith(".txt")) {
                System.out.println(f.getName());
            } else {
                if (f.isDirectory()) {
                    findAllTxt(f);
                }
            }
        }

    }

    public static void test() throws Exception {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("D://test.txt"));
//        dos.write(12);  //只会写int的后8位   前24位都抛弃了
//        System.out.println((char)12);
//        dos.writeInt(24);
        dos.writeBoolean(true);
//        dos.writeUTF("hello");
//        System.out.println((char)true);
        DataInputStream dis = new DataInputStream(new FileInputStream("D://test.txt"));
//        int i = dis.readInt();
        boolean b = dis.readBoolean();
        System.out.println(b);
    }
}
