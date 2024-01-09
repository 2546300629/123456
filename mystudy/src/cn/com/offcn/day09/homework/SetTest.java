package cn.com.offcn.day09.homework;

import cn.com.offcn.day09.homework.User;

import java.util.HashSet;

public class SetTest {
    public static void main(String[] args) {
        HashSet<User> users = new HashSet<>();
        User user1 = new User("1001", "张一", "123456", "部门1", 200.84);
        User user2 = new User("1001", "张一", "123456", "部门1", 500.01);
        users.add(user1);
        users.add(user2);
        System.out.println("user1="+user1.hashCode());
        System.out.println("user2="+user2.hashCode());
        System.out.println(user1.equals(user2));
//        System.out.println("1001".hashCode());
        System.out.println(users);
    }
}
