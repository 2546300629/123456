package cn.com.offcn.day08;

import java.io.*;
import java.util.*;

public class SequenceInputStreamTest {
    public static void main(String[] args) {
        try {
            FileInputStream in1 = new FileInputStream("D:\\io\\a.txt");
            FileInputStream in2 = new FileInputStream("D:\\io\\c.txt");
            FileInputStream in3 = new FileInputStream("D:\\io\\b.txt");
            HashSet<FileInputStream> set = new HashSet<>();
            set.add(in1);
            set.add(in2);
            set.add(in3);
            Iterator<FileInputStream> it = set.iterator();
            SequenceInputStream sis = new SequenceInputStream(new Enumeration<InputStream>() {
                @Override
                public boolean hasMoreElements() {
                    return it.hasNext();
                }

                @Override
                public InputStream nextElement() {
                    return it.next();
                }
            });
            FileOutputStream os = new FileOutputStream("D:\\io\\abc.txt");
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = sis.read(bytes)) != -1) {
                String  s=new String(bytes,0,len);
                System.out.println(s);


                os.write(bytes,0,len);
            }
//            os.flush();
            os.close();
            in3.close();
            in2.close();
            in1.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
