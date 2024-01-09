import java.util.ArrayList;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        boolean num = test.num(444);
        System.out.println(num);
    }

    public boolean num(int a) {
        boolean result = false;
        for (int i = 1; i < a;i++){
            if (check(i,a - i)){
                System.out.println(a + "=" + i +"+" + (a - i));
                result = true;
            }
        }
        return result;
    }

    public boolean check(int a, int b) {
        String num1 = a + "";
        String num2 = b + "";
        int length1 = num1.length();
        int length2 = num2.length();
        if (length2 != length1) {
            if (a > b) {
                for (int i = 0; i < length1 - length2; i++) {
                    num2 = "0" + num2;
                }
            } else if (a < b) {
                for (int i = 0; i < length2 - length1; i++) {
                    num1 = "0" + num1;
                }
            } else {
                if (a < 10 && b < 10) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        char[] a1 = num1.toCharArray();
        char[] b1 = num2.toCharArray();
        boolean result = true;
        for (int i = 0; i < a1.length; i ++) {
            if (a1[i] != b1[a1.length - 1 - i]){
                result = false;
            }
        }
        return result;
    }

}
