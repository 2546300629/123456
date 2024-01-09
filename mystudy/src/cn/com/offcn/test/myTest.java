package cn.com.offcn.test;

import java.util.*;

public class myTest {
    public static void main(String[] args) {
//        mathnum();
//        rabbits();
//        people.offer(new Person("sss"));

removeArray();

    }

    public static void removeArray() {
//        int[] arr = {4,3,1,1,3,3,2};
//        System.out.print("之前的数组：");
//        for (int x : arr){
//            System.out.print(x+"\t");
//        }
//        System.out.println();
//        //有效元素个数统计变量
//        int index = arr.length;
//        //删除数组中元素的索引
//        int delIndex = 6;
//        for (int i = delIndex;i< arr.length-1;i++){
//            arr[i] = arr[i+1];
//        }
//        arr[arr.length-1] = 0;
//        index--;
//        System.out.print("之后的数组：");
//        for (int i = 0;i<index;i++){
//            System.out.print(arr[i]+"\t");
//        }
    }

    private static ListNode removeNodes(ListNode head) {
        if (head.next == null) {
            return head;
        }
        head.next = removeNodes(head.next);
        if (head.next.val > head.val && head.next != null) {
            return head.next;
        }else {
            return head;
        }
//        return  null;
    }

    private static void mathnum() {
        Scanner sc = new Scanner(System.in);
        int old = sc.nextInt();
        int num = old;
        int i = 3;
        int count = 0;
        String str = "";
        while (num != 1) {
            if (num % 2 == 0) {
                str = str + "2*";
                num = num / 2;
                continue;
            }
            if (num % i == 0) {
                str = str + i + "*";
                num = num / i;
                continue;
            } else {
                count++;
                i = i + (2 * count);
            }

            if (count > 7) {
                str = str + num + "*1";
                num = 1;
                continue;
            }
        }
        System.out.println(old + "=" + str);
    }

    public static void rabbits() {
        int old = 1;
        int child = 0;
        int lastOld = 1;
        int lastChild = 0;
        int temp = 1;
        int count = 1;
        while (count < 13) {
            if (count > 2) {
                child = lastOld;
                old = old + lastChild;
                temp = old + child;
                lastChild = child;
                lastOld = old;
                System.out.println(count + "月" + "的兔子总数为" + temp);
            } else {

            }
            count++;
        }

    }

    static void getNum(int num) {
        int old = 1;
        int new1 = 0;

        while (num > 2) {
            num--;
            int tem = old;  //  tem代表上个月的老兔子
            old += new1;    //  本月的老兔子等于上个月的老兔子加上上个月的新兔子
            new1 = tem;     //  新兔子数量与上个月的老兔子数量相同
//            System.out.println(old + new1);
        }
        System.out.println(old + new1);
    }
}
