package cn.com.offcn.day03;

import java.lang.annotation.ElementType;
import java.util.Locale;
import java.util.Scanner;

public class MyExceptionTest {

    public static void testMethod(String ele) throws MyException {



//        switch (ele) {
//            case "����":
//            case "����":
//            case "��è":
//                System.out.println(ele + "ִ�����");
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
            System.out.println("����2��" + i + "�η�Ϊ��" + pow);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        Boolean b = true;
        while (b) {
            System.out.println("��������Ҫִ�е����");
            Scanner scanner = new Scanner(System.in);
            String str = scanner.nextLine();
            str = str.toLowerCase(Locale.ROOT);
            if (str.equals("quit") || str.equals("end") || str.equals(" ") || str.isEmpty()) {
                b = false;
                System.out.println("�˳�����");
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
        System.out.println("����ִ�����");
    }
}
