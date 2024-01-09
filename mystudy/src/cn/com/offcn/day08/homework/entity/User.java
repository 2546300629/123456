package cn.com.offcn.day08.homework.entity;

import java.io.Serializable;

public class User implements Comparable,Serializable{
    private String id;  //  员工编号
    private String name;    //  员工姓名

    private String password;    //  登录密码
    private String sector;  //  员工部门
    private double salary;  //  员工薪水

    public User() {
    }

    public User(String id, String name, String password, String sector, double salary) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.sector = sector;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sector='" + sector + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof User) {
            User o1 = (User) o;
            return  (int)Math.round(this.getSalary() - o1.getSalary());
        }
        return 0;
    }
}
