package cn.com.offcn.day11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Demo {

    public static void main(String[] args) throws Exception{

        TT tt = new TT();
        tt.start();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            br.readLine();
            TT.flag = true;
            br.readLine();
            synchronized ("aaa") {
                "aaa".notify(); // notify()表示唤醒在这个对象下等待的某一个线程
                TT.flag = false;
            }
        }
    }
}

class TT extends Thread{

    public static boolean flag = false;

    public void run() {

        for(int i=1;i<=100;i++){
            if(flag){
                try {
                    synchronized ("aaa") {  // 调用wait()和 notify()方法的代码，必须放在同步代码块中
                        "aaa".wait(); // 当线程中调用了 "aaa".wait()时，表示当前线程在"aaa"这个对象下等待(进入了阻塞状态——挂起)
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("TT线程###"+i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}