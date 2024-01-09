package cn.com.offcn.test;

import java.util.Random;

public class ClassTest {
    static String[] arr;

    public static void main(String[] args) {
        Random random = new Random();
        String[] rows = new String[3];
        String[] lines1 = new String[4];
        String[] lines2 = new String[4];
        for (int i = 0; i < rows.length; i++) {
            String str = "";
            for (int j = 0; j < 31; j++) {
                str = count5(random, str);
            }
            rows[i] = str;
        }
        for (int i = 0; i < 4; i++) {
            String str = "";
            lines1[i] = "                               " + count5(random, str);
            lines2[i] = count5(random, str) + "                              ";
        }
        for (int i = 0; i < rows.length; i++) {
            String str = rows[i];
            str.indexOf("¡ï");
        }
        System.out.println(rows[0]);
        showArr(lines1);
        System.out.println(rows[1]);
        showArr(lines2);
        System.out.println(rows[2]);

    }

    private static String count5(Random random, String str) {
        switch (random.nextInt(15)) {
            case 0:
                str = str + "¡ö";
                break;
            case 1:
                str = str + "¡þ";
                break;
            case 2:
                str = str + "¡ï";
                break;
            case 3:
                str = str + "¡è";
                break;
            default:
                str = str + "¡Ë";
                break;
        }
        return str;
    }

    private static void showArr(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.println();
        }
    }
}
