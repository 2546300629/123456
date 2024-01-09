package org.example;

import org.example.entity.Person;
import org.example.entity.Student;
import org.example.entity.Teacher;
import org.example.inter.InterfaceDemo;
import org.example.thread.Test;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static int t = 100;
    public static void main(String[] args) {
        Thread test1 = new Thread(new Test(t),"窗口1");
        Thread test2 = new Thread(new Test(t),"窗口2");
        Thread test3 = new Thread(new Test(t),"窗口3");
//        test1.setName("窗口1");
//        test2.setName("窗口2");
//        test3.setName("窗口3");
        test1.run();
        test2.run();
        test3.run();
       /* List<Person> list = new ArrayList<>();
        list.add(new Student("学生1",12,"1"));
        list.add(new Student("学生2",13,"2"));
        list.add(new Student("学生3",14,"3"));
        list.add(new Teacher("老师1",15,"1"));
        list.add(new Teacher("老师1",16,"1"));
        list.add(new Person("路人1",18));
        list.add(new Person("路人2",19));
        boolean t = true;
        while(t) {
            t = false;
            for (Person p : list) {
                if (p.getTid() != null) {
                    list.remove(p);
                    t = true;
                    break;
                }
            }
        }

        for(Person p : list) {
            System.out.println(p.toString());
        }
*/

       /* InterfaceDemo a = (c,d)->{
            System.out.println("我是lamba表达式重写的方法");
            return c - d;
        };
        int i = a.test2(3, 5);
        System.out.println(6|3);
//        Assert.assertEquals("这...不对吧？",-3,i);
        */
    }
}