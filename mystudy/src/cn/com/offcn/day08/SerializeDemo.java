package cn.com.offcn.day08;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializeDemo {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("张三", "zhangsan", "beijing", 12));
        list.add(new Student("李四", "lisi", "shanghai", 23));
        list.add(new Student("王五", "wangwu", "tianjin", 13));
        FileOutputStream os = null;
        ObjectOutputStream oos = null;
        try {
            os = new FileOutputStream("d:\\test.txt");
            oos = new ObjectOutputStream(os);
            oos.writeObject(list);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                if (oos != null) {
                    try {
                        oos.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }

        Object o = null;
        FileInputStream is = null;
        ObjectInputStream ois = null;
        try {
            is = new FileInputStream("d:\\test.txt");
            ois = new ObjectInputStream(is);
            o = ois.readObject();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if (is!=null) {
                try {
                    is.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        System.out.println(o);
        for (Object o1 : (List) o) {
            System.out.println(o1);
            Student s = (Student) o1;
            System.out.println(s.name);
        }

    }
}
