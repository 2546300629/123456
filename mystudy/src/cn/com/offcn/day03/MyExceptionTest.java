package cn.com.offcn.day03;

import java.lang.annotation.ElementType;
import java.util.Locale;
import java.util.Scanner;

public class MyExceptionTest {

    public static void testMethod(String ele) throws MyException {



//        switch (ele) {
//            case "测试":
//            case "张三":
//            case "天猫":
//                System.out.println(ele + "执行完成");
//                break;
//            default:
//                throw new MyException(ele);
//        }
    }

    public static void computChar(String ele) {
        try {
            int com = ele.indexOf("com");
            ele = ele.substring(0,com);
            System.out.println(ele);
            int i = Integer.parseInt(ele);
            double pow = Math.pow(2, i);
            System.out.println("计算2的" + i + "次方为：" + pow);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        Boolean b = true;
        while (b) {
            System.out.println("请输入您要执行的命令：");
            Scanner scanner = new Scanner(System.in);
            String str = scanner.nextLine();
            str = str.toLowerCase(Locale.ROOT);
            if (str.equals("quit") || str.equals("end") || str.equals(" ") || str.isEmpty()) {
                b = false;
                System.out.println("退出任务");
            } else if (str.endsWith("com")) {
                MyExceptionTest.computChar(str);
            } else {
                try {
                    MyExceptionTest.testMethod(str);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("代码执行完毕");
    }
}
