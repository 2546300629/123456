package cn.com.offcn.day09.arrays;

import cn.com.offcn.day08.homework.entity.User;

import java.util.Arrays;

public class ArraysTest {
    public static void main(String[] args) {
//        int[] arr = {2,6,3,9,1,4,3,12};
//        Arrays.sort(arr);
//        System.out.println(Arrays.toString(arr));
//        int i = Arrays.binarySearch(arr, 4);
//        System.out.println(i);
        User[] users = {
                new User("1001", "张一", "123456", "部门1", 200.84),
                new User("1002", "张二", "123456", "部门2", 500.01),
                new User("1003", "张三", "123456", "部门3", 20.00),
                new User("1004", "张四", "123456", "部门4", 1200.61),
                new User("1005", "张五", "123456", "部门5", 100000)
        };
        Arrays.sort(users);
        System.out.println(Arrays.toString(users));
    }
}
