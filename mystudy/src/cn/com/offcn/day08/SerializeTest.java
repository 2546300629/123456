package cn.com.offcn.day08;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializeTest {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student("张三","zhangsan", "beijing",23));
        list.add(new Student("李四","lisi", "shanghai",28));
        list.add(new Student("王五","wangwu", "guangzhou",13));
        list.add(new Student("赵柳","zhaoliu", "miandian",40));

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\io\\a.txt"));
            oos.writeObject(list);
            oos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\io\\a.txt"));
            Object o = ois.readObject();
            for (Object o1 : (List)o){
                Student student = (Student) o1;
                System.out.println(student.toString());
            }
            ois.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
