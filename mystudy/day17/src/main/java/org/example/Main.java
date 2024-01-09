package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入第一个数字：");
        int a = sc.nextInt();
        System.out.print("请输入第二个数字：");
        int b = sc.nextInt();
        main.countNum(a, b);
    }

    public void countNum(int a, int b) {
//        计算最大公因数
        int min = a > b ? b : a;
        for (int i = min; i >= 1; i--) {
            if (a % i == 0 && b % i == 0) {
                System.out.println("最大公因数为" + i);
                break;
            }
        }
//        计算最小公倍数
        int max = a > b ? a : b;
        for (int i = max; i <= a * b; i++) {
            if (i % a == 0 && i % b == 0) {
                System.out.println("最小公倍数为" + i);
                break;
            }
        }
    }
}