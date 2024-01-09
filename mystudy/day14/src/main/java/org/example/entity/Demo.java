package org.example.entity;

public class Demo {
    private String name;
    public String sex;
    private int age;
    public final  double PI = 3.14d;

    private Demo() {
        System.out.println("我是Demo使用private修饰的无参构造函数");
    }
    public Demo(String name) {
        System.out.println("name=" + name);
        System.out.println("我是Demo使用public修饰的有参构造函数");
    }

    private Demo(String name,String sex,int age) {
        System.out.println("我是Demo使用private修饰的有参构造函数");
    }

    public void test() {
        System.out.println("我是Demo的public修饰方法");
    }
    private void test1() {
        System.out.println("我是Demo的private修饰方法");
    }

    private int test2(String name) {
        System.out.println("name=" + name);
        System.out.println("我是Demo的private修饰方法");
        return 3;
    }
}
