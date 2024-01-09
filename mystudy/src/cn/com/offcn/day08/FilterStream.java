package cn.com.offcn.day08;

import java.io.*;

public class FilterStream {
    public static void main(String[] args) {
//        InputStream in = System.in;
        FileInputStream in = null;
        try {
            in = new FileInputStream("d:\\io\\a.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        InputStreamReader ir = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(ir);
//        System.out.println("请输入您要录入的数据");
        String s = null;
        while (true) {
            try {
                if (!((s = br.readLine())!= null)) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println(s);
        }


    }
}
