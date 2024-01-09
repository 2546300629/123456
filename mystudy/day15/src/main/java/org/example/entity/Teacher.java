package org.example.entity;

public class Teacher extends Person{
    private String tid;

    public Teacher() {
    }


    public Teacher(String name, int age, String tid) {
        super(name, age);
        this.tid = tid;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "tid='" + tid + '\'' +
                '}';
    }
}
