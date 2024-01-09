package org.example.entity;

public class Student extends Person{
    private String sid;
    private String classroom;

    public Student() {
    }

    public Student(String name, int age, String sex, String sid, String classroom) {
        super(name, age, sex);
        this.sid = sid;
        this.classroom = classroom;
    }

    public Student(String sid, String classroom) {
        this.sid = sid;
        this.classroom = classroom;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid='" + sid + '\'' +
                ",name='"+super.getName() +'\''+
                ",sex='"+super.getSex() +'\''+
                ",age='"+super.getAge() +'\''+
                ", classroom='" + classroom + '\'' +
                '}';
    }
}
