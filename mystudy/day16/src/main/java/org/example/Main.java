package org.example;

import org.example.entity.Person;
import org.example.entity.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
//        消费式函数接口 传入一个泛型类T，无返回值
//        Consumer c = (s)->{
//            System.out.println("传入" + s);
//        };
//        c.accept("测试");

//        供给式接口 不需要传入值，返回一个泛型类T
//        Test test = new Test();
//        Supplier sup = test :: test1;
//        Object o = sup.get();
//        System.out.println(o);

//        断言式函数接口 传入一个泛型类T，返回一个布尔类型的值
//        Predicate<String> pre = (s) -> {
//            return s.length() > 3;
//        };
//        boolean hello = pre.test("hello");
//        System.out.println(hello);

//      函数式接口 传入一个泛型类T，返回一个泛型类R
//        Function<Integer,Integer> f = (s)->{
//            s = s+1;
//            return s;
//        };
//        Integer apply = f.apply(2);
//        System.out.println(apply);

//        传入两个泛型类T和H，返回一个泛型类R
//        BiFunction<String,Integer ,String> bf = (a,b)->{
//          return a+b;
//        };
//        String apply = bf.apply("123", 2);
//        System.out.println(apply);

//      传入一个泛型T，返回一个泛型T
//        UnaryOperator<String> un = (s) -> {
//            return "接收到数据" + s;
//        };
//        System.out.println(un.apply("ceshi"));
        ArrayList<Student> list = new ArrayList<>();
        Student student1 = new Student("张一", 20, "男", "1", "一班");
        Student student2 = new Student("张二", 18, "女", "2", "一班");
        Student student3 = new Student("张三", 17, "男", "3", "二班");
        Student student4 = new Student("王四", 18, "女", "4", "一班");
        Student student5 = new Student("李五", 15, "男", "5", "一班");
        list.add(student1);
        list.add(student2);
        list.add(student3);
        list.add(student4);
        list.add(student5);
        Predicate<Student> p = x -> x.getClassroom().equals("二班");
        list.stream().filter(x -> x.getSex().equals("男")).filter(p.negate()).forEach(System.out::println);
//        long count = list.stream().filter(x -> x.getSex().equals("男")).filter(p.negate()).count();
//        List<Student> list1 = list.stream().filter(x -> x.getSex().equals("男")).limit(3).collect(Collectors.toList());
//        list1.stream().forEach(System.out::println);
//        list.stream().filter(x -> x.getSex().equals("男")).limit(3);
    }
}