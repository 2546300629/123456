package org.example.homework.work2;

import java.util.ArrayList;
import java.util.Arrays;

public class work2 {
    public static void main(String[] args) {
//        int[] arr = {2, 4, 1, 6, 12, 56, 83, 3};
        work2 work2 = new work2();
        int[][] arr = {{2, 5}, {34, 3}, {10, 23}, {7, 90}};
        int[] b = work2.changeArr(arr);
        int[] bubble = work2.Bubble(b);
        System.out.println(Arrays.toString(bubble));
//        int[] bubble = work2.Bubble(arr);
//        System.out.println(Arrays.toString(bubble));
    }

//    二维数组变成一维数组并排序
    public int[] changeArr(int[] [] a) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < a.length; i ++) {
            for (int j = 0; j < a[i].length;j++) {
                list.add(a[i][j]);
            }
        }
        Integer[] integers = list.toArray(new Integer[list.size()]);
        int[] b = Arrays.stream(integers).mapToInt(Integer::valueOf).toArray();
        return b;
//        Arrays.sort(b);
//        System.out.println(Arrays.toString(b));
    }

    //    求二维数组的和
    public void ArraySum(int[][] a) {
        String str = "";
        int sum = 0;
        for (int x = 0; x < a.length; x++) {   //  循环最外层
            int[] b = a[x];
            Arrays.sort(b);
            a[x] = b;
            int count = 0;
            for (int i = 0; i < b.length; i++) {
                count += b[i];
                sum += b[i];
            }
            str += count + "+";
        }
        str = str.substring(0,str.length() - 1);
        str = str + "=" + sum;
        System.out.println(str);
    }

    //    冒泡排序
    public int[] Bubble(int[] a) {
        int[] b = a;
        for (int i = 1; i < b.length; i++) {
            boolean flag = true;    //  当flag为true的时候表示本次循环没有交换，也就是排序完成
            for (int j = 0; j < b.length - i; j++) {
                if (b[j] > b[j + 1]) {
                    int tmp = b[j];
                    b[j] = b[j + 1];
                    b[j + 1] = tmp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
        return b;
    }

    //首尾交换位置
    public int[] OneAndLast(int[] a) {
        int x = a[0];
        a[0] = a[a.length - 1];
        a[a.length - 1] = x;
        return a;
    }
}
