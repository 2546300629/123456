package cn.com.offcn.day09.homework;

import java.io.Serializable;
import java.util.Objects;

public class User extends Object implements Comparable<User>,Serializable{
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
    public int compareTo(User o) {
        int round = (int) Math.round(this.getSalary() - o.getSalary());
        return round;
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("调用重写后的方法");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
