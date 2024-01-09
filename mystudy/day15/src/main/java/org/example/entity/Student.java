package org.example.entity;

public class Student extends Person{
    private String sid;

    public Student() {
    }

    public Student(String name, int age, String sid) {
        super(name, age);
        this.sid = sid;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid='" + sid + '\'' +
                '}';
    }
}
