package cn.com.offcn.day10.runable;

public class RunableTest {
    public static void main(String[] args) {
        RunableA a = new RunableA();
        RunableB b = new RunableB();

        Thread ta = new Thread(a);
        Thread tb = new Thread(b);
//        ta.setDaemon(true);
        ta.start();
        tb.start();
    }
}
