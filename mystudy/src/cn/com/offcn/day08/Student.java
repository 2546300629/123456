package cn.com.offcn.day08;

import java.io.Serializable;

public class Student implements Serializable {
    public String name;
    public String msg;
    public String address;
    public int age;

    public Student() {
    }
    public Student(String name, String msg, String address, int age) {
        this.name = name;
        this.msg = msg;
        this.address = address;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", msg='" + msg + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                '}';
    }
}
