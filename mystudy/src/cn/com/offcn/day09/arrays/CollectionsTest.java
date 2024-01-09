package cn.com.offcn.day09.arrays;

import cn.com.offcn.day08.homework.entity.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsTest {

    public static void main(String[] args) {
        ArrayList<User> list = new ArrayList<>();
        list.add(new User("1001", "张一", "123456", "部门1", 200.84));
        list.add(new User("1002", "张二", "123456", "部门2", 500.01));
        list.add(new User("1003", "张三", "123456", "部门3", 20.00));
        list.add(new User("1004", "张四", "123456", "部门4", 1200.61));
        list.add(new User("1005", "张五", "123456", "部门5", 100000));
        Collections.sort(list);
        Collections.reverse(list);
        for (User user : list) {
            System.out.println(user.toString());
        }
    }
}
